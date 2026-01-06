package com.isa.platform.u20221b127.inventory.domain.model.valueobjects;

public record SerialNumber(String serialNumber) {
    public SerialNumber {
        if (serialNumber == null || serialNumber.isBlank()) {
            throw new IllegalArgumentException("Serial number cannot be null or empty");
        }
    }
}
