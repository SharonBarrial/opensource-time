package com.smarthome.platform.practica1.inventory.interfaces.rest.transform;

import com.smarthome.platform.practica1.inventory.domain.model.commands.UpdateDeviceCommand;
import com.smarthome.platform.practica1.inventory.interfaces.rest.resources.UpdateDeviceResource;

public class UpdateDeviceCommandFromResourceAssembler {
    public static UpdateDeviceCommand toCommandFromResource(UpdateDeviceResource resource, Long id) {
        return new UpdateDeviceCommand(
                id,
                resource.serialNumber(),
                resource.model(),
                resource.deviceType(),
                resource.installationDate(),
                resource.status()
        );
    }
}
