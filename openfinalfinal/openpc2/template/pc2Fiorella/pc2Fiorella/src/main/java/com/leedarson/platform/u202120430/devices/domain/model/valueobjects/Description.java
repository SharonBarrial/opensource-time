package com.leedarson.platform.u202120430.devices.domain.model.valueobjects;

/**
 * @author Nadia Alessandra Lucas Coronel
 * @version 1.0
 */
public record Description(String description) {
    public Description {
        if (description == null || description.isBlank() || description.length() > 360) {
            throw new IllegalArgumentException("Description must not be null or empty");
        }
    }
}
