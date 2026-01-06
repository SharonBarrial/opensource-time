package com.leedarson.platform.u20221a322.devices.interfaces.res.transforms;

import com.leedarson.platform.u20221a322.devices.domain.model.aggregates.Sensor;
import com.leedarson.platform.u20221a322.devices.interfaces.res.resources.SensorResource;

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: leedarson
 * Date: 12/06/24 @ 01:54
 */
public class SensorResourceFromEntityAssembler {

    /**
     * Transform a Sensor entity to a SensorResource
     *
     * @param entity the Sensor entity
     * @return the SensorResource
     */
    public static SensorResource toResourceFromEntity(Sensor entity) {
        return new SensorResource(
                entity.getId(),
                entity.getName(),
                entity.getSensorTypeId(),
                entity.getDescription(),
                entity.getManufacturer(),
                entity.getReferenceImageUrl()
        );
    }
}
