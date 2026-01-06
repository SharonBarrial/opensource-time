package com.smarthomemanagement.platform.tareaopensem14.inventory.domain.model.valueobjects;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */
public record Model(String model) {
    public Model {
        if (model == null || model.isBlank() || model.length() > 50) {
            throw new IllegalArgumentException("Model must not be null or empty");
        }
    }
}
