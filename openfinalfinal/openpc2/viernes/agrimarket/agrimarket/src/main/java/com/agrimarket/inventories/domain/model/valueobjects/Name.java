package com.agrimarket.inventories.domain.model.valueobjects;

/**
 * @author Sharon Antuanet Ivet Barrial Marin
 * @version 1.0
 */

public record Name(String name) {
    public Name {
        if (name == null || name.isBlank() || name.length() > 80) {
            throw new IllegalArgumentException("Name must not be null or empty");
        }
    }
}
