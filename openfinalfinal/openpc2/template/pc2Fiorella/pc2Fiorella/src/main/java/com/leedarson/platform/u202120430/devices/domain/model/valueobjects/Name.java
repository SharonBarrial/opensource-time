package com.leedarson.platform.u202120430.devices.domain.model.valueobjects;

/**
 * @author Nadia Alessandra Lucas Coronel
 * @version 1.0
 */
public record Name(String name) {
    public Name {
        if (name == null || name.isBlank() || name.length() > 50) {
            throw new IllegalArgumentException("Name must not be null or empty");
        }
    }
}
