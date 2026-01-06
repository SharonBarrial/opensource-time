package com.smarthome.platform.practica1.analytics.domain.model.valueobjects;

public record Description(String description) {
    public Description {
        if (description == null) {
            throw new IllegalArgumentException("Description cannot be null");
        }
        if (description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be blank");
        }
        // maximum length of 200 characters
        if (description.length() > 200) {
            throw new IllegalArgumentException("Description cannot be longer than 200 characters");
        }
    }
}
