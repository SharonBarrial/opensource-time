package com.smarthome.platform.practica1.analytics.domain.model.valueobjects;

public record MinValue(Double minValue) {
    public MinValue {
        if (minValue == null) {
            throw new IllegalArgumentException("Min value must not be null");
        }
        if (minValue < 0) {
            throw new IllegalArgumentException("Min value must be greater than or equal to 0");
        }
    }
}
