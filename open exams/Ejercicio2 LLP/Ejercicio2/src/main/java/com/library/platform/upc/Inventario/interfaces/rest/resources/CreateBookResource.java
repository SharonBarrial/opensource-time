package com.library.platform.upc.Inventario.interfaces.rest.resources;

import com.library.platform.upc.Inventario.domain.model.valueobjects.Status;

import java.util.Date;
import java.util.List;

public record CreateBookResource(
         String isbn,
         String title,
         String author,
         Date publishedDate,
         Status status,
         List<Long> genreIds
) {}