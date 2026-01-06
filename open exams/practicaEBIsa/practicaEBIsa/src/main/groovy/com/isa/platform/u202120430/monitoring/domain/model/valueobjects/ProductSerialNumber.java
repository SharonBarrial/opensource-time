package com.isa.platform.u202120430.monitoring.domain.model.valueobjects;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */
public record ProductSerialNumber(String productSerialNumber) {
    public ProductSerialNumber {
        if (productSerialNumber == null || productSerialNumber.isBlank() || productSerialNumber.length() > 50) {
            throw new IllegalArgumentException("Product serial number cannot be null or empty");
        }
    }
}
