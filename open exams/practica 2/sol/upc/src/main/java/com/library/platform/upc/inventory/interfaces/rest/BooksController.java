package com.library.platform.upc.inventory.interfaces.rest;


import com.library.platform.upc.inventory.domain.model.aggregates.Book;
import com.library.platform.upc.inventory.domain.model.queries.GetAllBooksQuery;
import com.library.platform.upc.inventory.domain.model.queries.GetBookByIdQuery;
import com.library.platform.upc.inventory.domain.services.BookCommandService;
import com.library.platform.upc.inventory.domain.services.BookQueryService;
import com.library.platform.upc.inventory.interfaces.rest.resources.BookResource;
import com.library.platform.upc.inventory.interfaces.rest.resources.CreateBookResource;
import com.library.platform.upc.inventory.interfaces.rest.resources.UpdateBookResource;
import com.library.platform.upc.inventory.interfaces.rest.transform.BookResourceFromEntityAssembler;
import com.library.platform.upc.inventory.interfaces.rest.transform.CreateBookCommandFromResourceAssembler;
import com.library.platform.upc.inventory.interfaces.rest.transform.UpdateBookCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value="api/v1/books", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Books", description = "Book Management Endpoints")
public class BooksController {
    private final BookCommandService bookCommandService;
    private final BookQueryService bookQueryService;

    public BooksController(BookCommandService bookCommandService, BookQueryService bookQueryService) {
        this.bookCommandService = bookCommandService;
        this.bookQueryService = bookQueryService;
    }
    @PreAuthorize("hasRole('ADMIN') or hasRole('LIBRARIAN') or hasRole('MEMBER')")
    @GetMapping
    public ResponseEntity<List<BookResource>> getAllBooks(){
        var getAllBooksQuery = new GetAllBooksQuery();
        var books = bookQueryService.handle(getAllBooksQuery);
        var bookResources =books.stream()
                .map(BookResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(bookResources);
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('LIBRARIAN')")
    @PostMapping
    public ResponseEntity<?> createBook(@Valid @RequestBody CreateBookResource createBookResource){
        var createBookCommand = CreateBookCommandFromResourceAssembler.toCommandFromResource(createBookResource);
        Long bookId;
        try {
            bookId = bookCommandService.handle(createBookCommand);
        } catch (Exception e){
            return ResponseEntity
                    .badRequest()
                    .contentType(MediaType.TEXT_PLAIN)
                    .body(e.getMessage());
        }

        if (bookId == 0L){
            return ResponseEntity.badRequest().build();
        }
        var getBookByIdQuery = new GetBookByIdQuery(bookId);
        var book = bookQueryService.handle(getBookByIdQuery);
        if (book.isEmpty()){ return ResponseEntity.badRequest().build(); }
        var bookResource = BookResourceFromEntityAssembler.toResourceFromEntity(book.get());
        return new ResponseEntity<>(bookResource, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('LIBRARIAN')")
    @PutMapping("/{bookId}")
    public ResponseEntity<?> updateBook(@PathVariable Long bookId, @Valid @RequestBody UpdateBookResource updateBookResource){
        var updateBookCommand = UpdateBookCommandFromResourceAssembler.toCommandFromResource(bookId, updateBookResource);
        Optional<Book> updatedBook;
        try {
            updatedBook = bookCommandService.handle(updateBookCommand);
        } catch (Exception e){
            return ResponseEntity
                    .badRequest()
                    .contentType(MediaType.TEXT_PLAIN)
                    .body(e.getMessage());
        }

        if (updatedBook.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var bookResource = BookResourceFromEntityAssembler.toResourceFromEntity(updatedBook.get());
        return new ResponseEntity<>(bookResource, HttpStatus.OK);
    }


}
