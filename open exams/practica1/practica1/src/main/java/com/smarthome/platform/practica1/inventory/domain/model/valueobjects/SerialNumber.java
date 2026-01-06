package com.smarthome.platform.practica1.inventory.domain.model.valueobjects;

public record SerialNumber(String serialNumber) {
    public SerialNumber {
        if (serialNumber == null) {
            throw new IllegalArgumentException("Serial number cannot be null");
        }
        if (serialNumber.isBlank()) {
            throw new IllegalArgumentException("Serial number cannot be empty");
        }
        // maximum length of 30 characters
        if (serialNumber.length() > 30) {
            throw new IllegalArgumentException("Serial number cannot be longer than 30 characters");
        }
    }
}
