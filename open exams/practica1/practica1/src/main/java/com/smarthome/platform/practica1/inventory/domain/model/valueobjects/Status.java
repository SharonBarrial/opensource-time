package com.smarthome.platform.practica1.inventory.domain.model.valueobjects;

public record Status(String status) {
    public Status {
        if (status == null) {
            throw new IllegalArgumentException("Status cannot be null");
        }
        if (status.isBlank()) {
            throw new IllegalArgumentException("Status cannot be empty");
        }
        // STATUS CANNOT BE LONGER THAN 10 CHARACTERS
        if (status.length() > 10) {
            throw new IllegalArgumentException("Status cannot be longer than 10 characters");
        }
        // ONLY CAN BE "ACTIVE" OR "INACTIVE"
        if (!status.equals("ACTIVE") && !status.equals("INACTIVE")) {
            throw new IllegalArgumentException("Status must be either 'ACTIVE' or 'INACTIVE'");
        }
    }
}
