package com.leedarson.platform.u20221a322.devices.domain.model.commands;

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: leedarson
 * Date: 12/06/24 @ 01:43
 */
public record CreateSensorCommand(
        String name,
        Long sensorTypeId,
        String description,
        String manufacturer,
        String referenceImageUrl
) {

    /**
     * @summary Validates the CreateSensorCommand with the following rules:
     * - name is required and must be less than 50 characters
     * - sensorTypeId is required
     * - description is required and must be less than 360 characters
     * - manufacturer is required and must be less than 100 characters
     * - referenceImageUrl is required
     */
    public CreateSensorCommand {
        if (name == null || name.isBlank() || name.length() > 50) {
            throw new IllegalArgumentException("Sensor name is required and must be less than 50 characters");
        }
        if (sensorTypeId == null || sensorTypeId <= 0) {
            throw new IllegalArgumentException("Sensor type is required");
        }
        if (description == null || description.isBlank() || description.length() > 360) {
            throw new IllegalArgumentException("Description is required and must be less than 360 characters");
        }
        if (manufacturer == null || manufacturer.isBlank() || manufacturer.length() > 100) {
            throw new IllegalArgumentException("Manufacturer is required and must be less than 100 characters");
        }
        if (referenceImageUrl == null || referenceImageUrl.isBlank()) {
            throw new IllegalArgumentException("Reference Image Url is required");
        }
    }
}
