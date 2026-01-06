package com.leedarson.platform.u202120430.devices.domain.model.commands;

/**
 * Command use to create a Sensor
 * @author Nadia Alessandra Lucas Coronel
 * @version 1.0
 */
public record CreateSensorCommand(
        String name,
        Long sensorTypeId,
        String description,
        String manufacturer,
        String referenceImageUrl){
}
