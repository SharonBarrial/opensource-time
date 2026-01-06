package com.leedarson.platform.u202120430.devices.interfaces.rest.resources;

import jakarta.validation.constraints.NotNull;

/**
 * Resource record for creating a sensor.
 * @author Nadia Alessandra Lucas Coronel
 * @version 1.0
 */
public record CreateSensorResource (
        @NotNull String name,
        @NotNull Long sensorTypeId,
        @NotNull String description,
        @NotNull String manufacturer,
        @NotNull String referenceImageUrl){
}
