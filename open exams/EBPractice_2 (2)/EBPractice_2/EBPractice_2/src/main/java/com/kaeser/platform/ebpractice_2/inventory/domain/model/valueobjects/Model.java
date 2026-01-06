package com.kaeser.platform.ebpractice_2.inventory.domain.model.valueobjects;

/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
public record Model(String model) {
    public Model {
        if (model == null || model.isBlank() || model.length() > 30) {
            throw new IllegalArgumentException("Model must not be null or empty");
        }
    }
}
