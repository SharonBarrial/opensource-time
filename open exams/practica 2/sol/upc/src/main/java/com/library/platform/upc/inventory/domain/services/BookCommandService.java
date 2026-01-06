package com.library.platform.upc.inventory.domain.services;

import com.library.platform.upc.inventory.domain.model.aggregates.Book;
import com.library.platform.upc.inventory.domain.model.commands.CreateBookCommand;
import com.library.platform.upc.inventory.domain.model.commands.UpdateBookCommand;

import java.util.Optional;

public interface BookCommandService {
    Long handle(CreateBookCommand createBookCommand);
    Optional<Book> handle(UpdateBookCommand updateBookCommand);
}
