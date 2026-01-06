package com.leedarson.platform.u202120430.devices.interfaces.rest.transform;

import com.leedarson.platform.u202120430.devices.domain.model.aggregates.Sensor;
import com.leedarson.platform.u202120430.devices.interfaces.rest.resources.SensorResource;

/**
 * This class is responsible for converting a Sensor object into a SensorResource object.
 * @author Nadia Alessandra Lucas Coronel
 * @version 1.0
 */
public class SensorResourceFromEntityAssembler {
    public static SensorResource toResourceFromEntity(Sensor entity) {
        return new SensorResource(
                entity.getId(),
                entity.getName(),
                entity.getSensorType().getId(),
                entity.getDescription(),
                entity.getManufacturer(),
                entity.getReferenceImageUrl()
        );
    }
}
