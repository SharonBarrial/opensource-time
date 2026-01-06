package com.isa.platform.u20221b127.inventory.domain.model.valueobjects;

public record Model(String model) {
    public Model {
        if (model == null || model.isBlank()) {
            throw new IllegalArgumentException("Model cannot be null or empty");
        }
    }
}
