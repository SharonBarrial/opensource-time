package com.sportnet.platform.u202120430.booking.domain.model.valueobjects;

public record EventName(String eventName) {
    public EventName {
        if (eventName == null || eventName.isBlank()) {
            throw new IllegalArgumentException("Event name cannot be null or blank");
        }
    }
}
