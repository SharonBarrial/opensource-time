package com.spotify.platform.u202114900.inventories.domain.models.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.Date;

@Embeddable
public record Year(Date year) {
    public Year {
        if (year == null || year.toString().isBlank()) {
            throw new IllegalArgumentException("Year is mandatory");
        }
    }

    public Date Year() { return year; }
}
