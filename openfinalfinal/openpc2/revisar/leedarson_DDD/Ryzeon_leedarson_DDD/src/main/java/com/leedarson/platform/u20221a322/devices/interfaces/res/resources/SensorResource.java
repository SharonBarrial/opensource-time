package com.leedarson.platform.u20221a322.devices.interfaces.res.resources;

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: leedarson
 * Date: 12/06/24 @ 01:53
 */
public record SensorResource(
        Long id,
        String name,
        Long sensorTypeId,
        String description,
        String manufacturer,
        String referenceImageUrl
) {
}
