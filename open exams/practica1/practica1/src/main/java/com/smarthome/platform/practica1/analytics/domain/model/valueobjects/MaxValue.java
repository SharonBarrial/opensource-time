package com.smarthome.platform.practica1.analytics.domain.model.valueobjects;

public record MaxValue(Double maxValue) {
    public MaxValue {
        if (maxValue == null) {
            throw new IllegalArgumentException("Max value must not be null");
        }
        if (maxValue < 0) {
            throw new IllegalArgumentException("Max value must be greater than or equal to 0");
        }
    }
}
