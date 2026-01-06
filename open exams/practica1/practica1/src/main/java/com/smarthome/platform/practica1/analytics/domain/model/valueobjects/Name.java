package com.smarthome.platform.practica1.analytics.domain.model.valueobjects;

public record Name(String name) {
    public Name {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        // maximum length of 40 characters
        if (name.length() > 40) {
            throw new IllegalArgumentException("Name cannot be longer than 40 characters");
        }
    }
}
