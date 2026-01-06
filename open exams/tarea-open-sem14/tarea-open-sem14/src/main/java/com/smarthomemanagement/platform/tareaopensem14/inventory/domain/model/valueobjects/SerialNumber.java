package com.smarthomemanagement.platform.tareaopensem14.inventory.domain.model.valueobjects;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */
public record SerialNumber(String serialNumber) {
    public SerialNumber {
        if (serialNumber == null || serialNumber.isBlank() || serialNumber.length() > 30) {
            throw new IllegalArgumentException("Serial number must not be null or empty");
        }
    }
}
