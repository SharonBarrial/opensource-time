package com.library.platform.upc.Inventario.interfaces.rest.transform;

import com.library.platform.upc.Inventario.domain.model.aggregates.Book;
import com.library.platform.upc.Inventario.domain.model.entities.Genre;
import com.library.platform.upc.Inventario.interfaces.rest.resources.BookResource;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
@Component
public class BookResourceFromEntityAssembler {

    public BookResource toResource(Book book) {
        return new BookResource(
                book.getId(),
                book.getIsbn(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublishedDate(),
                book.getStatus(),
                book.getGenres().stream().map(Genre::getName).collect(Collectors.toSet()),
                book.getCreatedAt(),
                book.getUpdatedAt()
        );
    }
}