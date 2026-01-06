package com.sportnet.platform.u202120430.booking.domain.model.valueobjects;

public record Location(String location) {
    public Location {
        if (location == null || location.isBlank()) {
            throw new IllegalArgumentException("Location cannot be null or blank");
        }
    }
}
