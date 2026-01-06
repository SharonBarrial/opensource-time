package com.library.platform.upc.Inventario.domain.model.commands;

import com.library.platform.upc.Inventario.domain.model.entities.Genre;
import com.library.platform.upc.Inventario.domain.model.valueobjects.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import java.util.Date;
import java.util.List;

public record CreateBookCommand(
        @NotBlank @Size(max = 13) String isbn,
        @NotBlank @Size(max = 100) String title,
        @NotBlank @Size(max = 50) String author,
        @NotNull @PastOrPresent(message = "The published date cannot be in the future") Date publishedDate,
        @NotBlank @Size(max = 10) Status status,
        @NotNull List<Long> genreIds
) {
    public CreateBookCommand {
        if (isbn == null || isbn.isBlank() || isbn.length() > 13) {
            throw new IllegalArgumentException("ISBN is required and must be less than 13 characters.");
        }
        if (title == null || title.isBlank() || title.length() > 100) {
            throw new IllegalArgumentException("Title is required and must be less than 100 characters.");
        }
        if (author == null || author.isBlank() || author.length() > 50) {
            throw new IllegalArgumentException("Author is required and must be less than 50 characters.");
        }
        if (publishedDate == null) {
            throw new IllegalArgumentException("Published Date is required.");
        }
        if (status == null ) {
            throw new IllegalArgumentException("Status is required and must be less than 10 characters.");
        }
        if (genreIds == null || genreIds.isEmpty()) {
            throw new IllegalArgumentException("At least one Genre ID is required.");
        }
    }
}

