package com.library.platform.upc.inventory.application.internal.queryservices;

import com.library.platform.upc.inventory.domain.model.aggregates.Book;
import com.library.platform.upc.inventory.domain.model.queries.GetAllBooksQuery;
import com.library.platform.upc.inventory.domain.model.queries.GetBookByIdQuery;
import com.library.platform.upc.inventory.domain.model.queries.GetBookByIsbnQuery;
import com.library.platform.upc.inventory.domain.services.BookQueryService;
import com.library.platform.upc.inventory.infrastructure.persistence.jpa.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookQueryServiceImpl implements BookQueryService {
    private final BookRepository bookRepository;

    public BookQueryServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Optional<Book> handle(GetBookByIdQuery query) {
        return bookRepository.findById(query.bookId());
    }

    @Override
    public List<Book> handle(GetAllBooksQuery query) {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> handle(GetBookByIsbnQuery query) {
        return bookRepository.findByIsbn(query.isbn());
    }


}
