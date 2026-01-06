package com.library.platform.upc.inventory.interfaces.rest.transform;

import com.library.platform.upc.inventory.domain.model.aggregates.Book;
import com.library.platform.upc.inventory.interfaces.rest.resources.BookResource;

public class BookResourceFromEntityAssembler {
    public static BookResource toResourceFromEntity(Book entity) {
        return new BookResource(
                entity.getId(),
                entity.getIsbn(),
                entity.getTitle(),
                entity.getAuthor(),
                entity.getPublishedDate(),
                entity.getStatus(),
                entity.getGenre().getId()
        );
    }
}
