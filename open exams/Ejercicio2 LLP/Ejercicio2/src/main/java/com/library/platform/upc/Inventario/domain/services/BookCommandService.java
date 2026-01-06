package com.library.platform.upc.Inventario.domain.services;

import com.library.platform.upc.Inventario.domain.model.aggregates.Book;
import com.library.platform.upc.Inventario.domain.model.commands.CreateBookCommand;

import java.util.Optional;

public interface BookCommandService {
    Optional<Book> handle(CreateBookCommand command);
    Optional<Book> update(Long id, CreateBookCommand command);

}
