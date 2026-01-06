package com.library.platform.upc.inventory.domain.services;

import com.library.platform.upc.inventory.domain.model.aggregates.Book;
import com.library.platform.upc.inventory.domain.model.queries.GetAllBooksQuery;
import com.library.platform.upc.inventory.domain.model.queries.GetBookByIdQuery;
import com.library.platform.upc.inventory.domain.model.queries.GetBookByIsbnQuery;

import java.util.List;
import java.util.Optional;

public interface BookQueryService {
    List<Book> handle(GetAllBooksQuery query);
    Optional<Book> handle(GetBookByIdQuery query);
    Optional<Book> handle(GetBookByIsbnQuery query);
}
