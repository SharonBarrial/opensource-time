package com.agrimarket.inventories.domain.model.valueobjects;
/**
 * @author Sharon Antuanet Ivet Barrial Marin
 * @version 1.0
 */
public record Description(String description) {
    public Description {
        if (description == null || description.isBlank() || description.length() > 350) {
            throw new IllegalArgumentException("Description must not be null or empty");
        }
    }
}
