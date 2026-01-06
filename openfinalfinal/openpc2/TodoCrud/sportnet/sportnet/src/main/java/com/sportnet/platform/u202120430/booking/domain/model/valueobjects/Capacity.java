package com.sportnet.platform.u202120430.booking.domain.model.valueobjects;

public record Capacity(Integer capacity) {
    public Capacity {
        if (capacity == null || capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be a positive number");
        }
    }
}
