package com.isa.platform.u20221b127.monitoring.domain.model.valueobjects;

public record Leakage(Integer leakage) {
    public Leakage {
        if (leakage != 0 && leakage != 1) {
            throw new IllegalArgumentException("Leakage can only be 0 or 1");
        }
    }
}
