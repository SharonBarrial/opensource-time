package com.library.platform.upc.Inventario.application.internal.commandservices;

import com.library.platform.upc.Inventario.domain.model.aggregates.Book;
import com.library.platform.upc.Inventario.domain.model.commands.CreateBookCommand;
import com.library.platform.upc.Inventario.domain.services.BookCommandService;
import com.library.platform.upc.Inventario.infrastructure.persistence.jpa.BookRepository;
import com.library.platform.upc.Inventario.infrastructure.persistence.jpa.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class BookCommandServiceImpl implements BookCommandService {

    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;

    @Autowired
    public BookCommandServiceImpl(BookRepository bookRepository, GenreRepository genreRepository) {
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public Optional<Book> handle(CreateBookCommand command) {
        if (bookRepository.existsByIsbn(command.isbn())) {
            return Optional.empty();
        }

        var genres = genreRepository.findAllById(command.genreIds());
        if (genres.isEmpty()) {
            throw new IllegalArgumentException("Invalid genre IDs");
        }

        Book book = new Book(command.isbn(), command.title(), command.author(), command.publishedDate(), command.status(), genres);
        bookRepository.save(book);

        return Optional.of(book);
    }

    @Override
    public Optional<Book> update(Long id, CreateBookCommand command) {
        return bookRepository.findById(id).map(book -> {
            book.setIsbn(command.isbn());
            book.setTitle(command.title());
            book.setAuthor(command.author());
            book.setPublishedDate(command.publishedDate());
            book.setStatus(command.status());
            var genres = genreRepository.findAllById(command.genreIds());
            if (genres.isEmpty()) {
                throw new IllegalArgumentException("Invalid genre IDs");
            }
            book.setGenres(new HashSet<>(genres));
            bookRepository.save(book);
            return book;
        });
    }
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}