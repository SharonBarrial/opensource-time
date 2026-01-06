package com.leedarson.platform.u202120430.devices.domain.model.valueobjects;

/**
 * @author Nadia Alessandra Lucas Coronel
 * @version 1.0
 */
public record Manufacturer(String manufacturer) {
    public Manufacturer {
        if (manufacturer == null || manufacturer.isBlank() || manufacturer.length() > 100) {
            throw new IllegalArgumentException("Manufacturer must not be null or empty");
        }
    }
}
