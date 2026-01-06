package com.sportnet.platform.u202120430.booking.domain.model.valueobjects;

public record SportType(String sportType) {
    public SportType {
        if (sportType == null || sportType.isBlank()) {
            throw new IllegalArgumentException("Sport type cannot be null or blank");
        }
    }
}
