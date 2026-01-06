package com.isa.platform.u20221b127.inventory.domain.model.valueobjects;

public record Brand(String brand) {
    public Brand {
        if (brand == null || brand.isBlank()) {
            throw new IllegalArgumentException("Brand cannot be null or empty");
        }
    }
}
