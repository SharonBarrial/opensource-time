package com.isa.platform.u202120430.monitoring.domain.model.valueobjects;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */
public record Leakage(Integer leakage) {
    public Leakage {
        if (leakage < 0) {
            throw new IllegalArgumentException("Leakage must be greater than or equal to 0");
        }
    }
}
