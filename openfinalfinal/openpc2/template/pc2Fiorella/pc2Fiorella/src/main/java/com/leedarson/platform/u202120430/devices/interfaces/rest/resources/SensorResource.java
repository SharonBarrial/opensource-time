package com.leedarson.platform.u202120430.devices.interfaces.rest.resources;

/**
 * How the created response should look like
 * @author Nadia Alessandra Lucas Coronel
 * @version 1.0
 */
public record SensorResource (
        Long id,
        String name,
        Long sensorTypeId,
        String description,
        String manufacturer,
        String referenceImageUrl){
}
