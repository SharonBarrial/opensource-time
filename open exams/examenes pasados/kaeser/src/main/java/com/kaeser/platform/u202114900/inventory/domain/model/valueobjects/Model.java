package com.kaeser.platform.u202114900.inventory.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */

@Embeddable
public record Model(String model) {
    public Model {
        if (model == null || model.isBlank() || model.length() > 30) {
            throw new IllegalArgumentException("Model must not be null or empty");
        }
    }
}
