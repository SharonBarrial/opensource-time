package com.library.platform.upc.Inventario.interfaces.rest;

import com.library.platform.upc.Inventario.application.internal.commandservices.BookCommandServiceImpl;
import com.library.platform.upc.Inventario.domain.model.aggregates.Book;
import com.library.platform.upc.Inventario.domain.model.commands.CreateBookCommand;
import com.library.platform.upc.Inventario.interfaces.rest.resources.BookResource;
import com.library.platform.upc.Inventario.interfaces.rest.resources.CreateBookResource;
import com.library.platform.upc.Inventario.interfaces.rest.transform.BookResourceFromEntityAssembler;
import com.library.platform.upc.Inventario.interfaces.rest.transform.CreateBookCommandFromResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookCommandServiceImpl bookCommandService;
    private final CreateBookCommandFromResourceAssembler createBookCommandFromResourceAssembler;
    private final BookResourceFromEntityAssembler bookResourceFromEntityAssembler;

    @Autowired
    public BookController(BookCommandServiceImpl bookCommandService,
                          CreateBookCommandFromResourceAssembler createBookCommandFromResourceAssembler,
                          BookResourceFromEntityAssembler bookResourceFromEntityAssembler) {
        this.bookCommandService = bookCommandService;
        this.createBookCommandFromResourceAssembler = createBookCommandFromResourceAssembler;
        this.bookResourceFromEntityAssembler = bookResourceFromEntityAssembler;
    }

    @PostMapping
    public ResponseEntity<BookResource> createBook(@RequestBody CreateBookResource resource) {
        CreateBookCommand command = createBookCommandFromResourceAssembler.toCommand(resource);
        Optional<Book> book = bookCommandService.handle(command);
        if (book.isPresent()) {
            BookResource bookResource = bookResourceFromEntityAssembler.toResource(book.get());
            return ResponseEntity.created(URI.create("/api/v1/books/" + bookResource.id())).body(bookResource);
        } else {
            return ResponseEntity.status(409).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResource> updateBook(@PathVariable Long id, @RequestBody CreateBookResource resource) {
        CreateBookCommand command = createBookCommandFromResourceAssembler.toCommand(resource);
        Optional<Book> updatedBook = bookCommandService.update(id, command);

        if (updatedBook.isPresent()) {
            BookResource bookResource = bookResourceFromEntityAssembler.toResource(updatedBook.get());
            return ResponseEntity.ok(bookResource);
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<BookResource>> listBooks() {
        List<Book> books = bookCommandService.findAll();
        List<BookResource> bookResources = books.stream()
                .map(bookResourceFromEntityAssembler::toResource)
                .collect(Collectors.toList());
        return ResponseEntity.ok(bookResources);
    }
}