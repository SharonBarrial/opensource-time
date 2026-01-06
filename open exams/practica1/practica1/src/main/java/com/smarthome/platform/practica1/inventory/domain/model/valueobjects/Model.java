package com.smarthome.platform.practica1.inventory.domain.model.valueobjects;

public record Model(String model) {
    public Model {
        if (model == null) {
            throw new IllegalArgumentException("Model cannot be null");
        }
        if (model.isBlank()) {
            throw new IllegalArgumentException("Model cannot be empty");
        }
        // maximum length of 50 characters
        if (model.length() > 50) {
            throw new IllegalArgumentException("Model cannot be longer than 50 characters");
        }
    }
}
