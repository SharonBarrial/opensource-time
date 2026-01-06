package com.isa.platform.u202120430.inventory.domain.model.valueobjects;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */
public record Brand(String brand) {
    public Brand {
        if (brand == null || brand.isBlank() || brand.length() > 50) {
            throw new IllegalArgumentException("Brand must not be null or empty");
        }
    }
}
