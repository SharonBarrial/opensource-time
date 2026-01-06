package com.isa.platform.u202120430.monitoring.domain.model.valueobjects;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */
public record Temperature(Double temperature) {
    public Temperature {
        if (temperature < -273.15) {
            throw new IllegalArgumentException("Temperature cannot be less than -273.15 degrees Celsius.");
        }
    }
}
