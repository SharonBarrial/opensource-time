package com.library.platform.upc.inventory.application.internal.commandservices;

import com.library.platform.upc.inventory.domain.exceptions.GenreNotFoundException;
import com.library.platform.upc.inventory.domain.exceptions.SameIsbnException;
import com.library.platform.upc.inventory.domain.model.aggregates.Book;
import com.library.platform.upc.inventory.domain.model.commands.CreateBookCommand;
import com.library.platform.upc.inventory.domain.model.commands.UpdateBookCommand;
import com.library.platform.upc.inventory.domain.services.BookCommandService;
import com.library.platform.upc.inventory.infrastructure.persistence.jpa.repositories.BookRepository;
import com.library.platform.upc.inventory.infrastructure.persistence.jpa.repositories.GenreRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class BookCommandServiceImpl implements BookCommandService {
    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;
    private final Validator validator;

    public BookCommandServiceImpl(BookRepository bookRepository, GenreRepository genreRepository, Validator validator) {
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
        this.validator = validator;
    }

    @Override
    public Long handle(CreateBookCommand command) {
        var genre = genreRepository.findById(command.genreId());
        if (genre.isEmpty()) { throw new GenreNotFoundException(command.genreId()); }

        var sameIsbn = bookRepository.findByIsbn(command.isbn());
        if (sameIsbn.isPresent()) { throw new SameIsbnException(command.isbn()); }

        Book book = new Book(command, genre.get());
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving book: " + e.getMessage());
        }
        return book.getId();
    }

    @Override
    public Optional<Book> handle(UpdateBookCommand command) {
        var book = bookRepository.findById(command.id());
        if (book.isEmpty()) { return Optional.empty(); }
        Book bookToUpdate = book.get();

        var genre = genreRepository.findById(command.genreId());
        if (genre.isEmpty()) { throw new GenreNotFoundException(command.genreId()); }

        try {
            Book updatedBook = bookToUpdate.update(command, genre.get());
            //Check if the updated book complies with the jakarta constraints
            Set<ConstraintViolation<Book>> violations = validator.validate(bookToUpdate);
            if (!violations.isEmpty()) {
                throw new ConstraintViolationException(violations);
            }
            bookRepository.save(updatedBook);
            return Optional.of(updatedBook);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating book: " + e.getMessage());
        }

    }
}
