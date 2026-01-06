package com.isa.platform.u20221b127.monitoring.domain.model.valueobjects;

public record Temperature(Double temperature) {
    public Temperature {
        if (temperature == null) {
            throw new IllegalArgumentException("Temperature cannot be null");
        }
        if (temperature < -273.15) {
            throw new IllegalArgumentException("Temperature cannot be lower than -273.15 degrees Celsius");
        }
    }
}
