package com.library.platform.upc.Inventario.interfaces.rest.resources;

import com.library.platform.upc.Inventario.domain.model.valueobjects.Genres;
import com.library.platform.upc.Inventario.domain.model.valueobjects.Status;

import java.util.Date;
import java.util.List;
import java.util.Set;

public record BookResource(
        Long id,
        String isbn,
        String title,
        String author,
        Date publishedDate,
        Status status,
        Set<Genres> genres,
        Date createdAt,
        Date updatedAt
) {}