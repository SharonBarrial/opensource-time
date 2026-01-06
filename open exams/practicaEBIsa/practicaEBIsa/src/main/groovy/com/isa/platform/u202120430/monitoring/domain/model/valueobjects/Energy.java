package com.isa.platform.u202120430.monitoring.domain.model.valueobjects;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */
public record Energy(double energy) {
    public Energy {
        if (energy < 0) {
            throw new IllegalArgumentException("Energy cannot be negative");
        }
    }
}
