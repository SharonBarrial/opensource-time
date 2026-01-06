package com.leedarson.platform.u20221a322.devices.interfaces.res.transforms;

import com.leedarson.platform.u20221a322.devices.domain.model.commands.CreateSensorCommand;
import com.leedarson.platform.u20221a322.devices.interfaces.res.resources.CreateSensorResource;

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: leedarson
 * Date: 12/06/24 @ 01:55
 */
public class CreateSensorCommandFromResourceAssembler {

    /**
     * Transform a CreateSensorResource into a CreateSensorCommand
     *
     * @param resource the resource to transform
     * @return the command
     */
    public static CreateSensorCommand toCommandFromResource(CreateSensorResource resource) {
        return new CreateSensorCommand(
                resource.name(),
                resource.sensorTypeId(),
                resource.description(),
                resource.manufacturer(),
                resource.referenceImageUrl()
        );
    }
}
