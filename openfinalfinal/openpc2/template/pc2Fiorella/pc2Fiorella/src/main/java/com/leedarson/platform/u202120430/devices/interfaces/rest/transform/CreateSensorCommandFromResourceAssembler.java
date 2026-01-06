package com.leedarson.platform.u202120430.devices.interfaces.rest.transform;

import com.leedarson.platform.u202120430.devices.domain.model.commands.CreateSensorCommand;
import com.leedarson.platform.u202120430.devices.interfaces.rest.resources.CreateSensorResource;

/**
 * This class is responsible for converting a CreateSensorResource object into a CreateSensorCommand object.
 * @author Nadia Alessandra Lucas Coronel
 * @version 1.0
 */
public class CreateSensorCommandFromResourceAssembler {
    public static CreateSensorCommand toCommandFromResource(CreateSensorResource resource) {
        return new CreateSensorCommand(
                resource.name(),
                resource.sensorTypeId(),
                resource.description(),
                resource.manufacturer(),
                resource.referenceImageUrl());
    }
}
