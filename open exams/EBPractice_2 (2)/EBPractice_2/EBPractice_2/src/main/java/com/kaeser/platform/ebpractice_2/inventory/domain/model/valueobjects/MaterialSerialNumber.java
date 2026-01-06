package com.kaeser.platform.ebpractice_2.inventory.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
@Embeddable
public record MaterialSerialNumber(String materialSerialNumber) {
    public MaterialSerialNumber {
        if (materialSerialNumber == null || materialSerialNumber.isBlank()) {
            throw new IllegalArgumentException("Material serial number cannot be null or blank");
        }
    }

    public static MaterialSerialNumber generate() {
        return new MaterialSerialNumber(UUID.randomUUID().toString());
    }
}
