package com.smarthome.platform.practica1.inventory.interfaces.rest.transform;

import com.smarthome.platform.practica1.inventory.domain.model.aggregates.Device;
import com.smarthome.platform.practica1.inventory.interfaces.rest.resources.DeviceResource;

public class DeviceResourceFromEntityAssembler {
    public static DeviceResource toResourceFromEntity(Device device) {
        return new DeviceResource(
                device.getId(),
                device.getSerialNumber(),
                device.getModel(),
                device.getDeviceType().getType(),
                device.getInstallationDate(),
                device.getStatus()
        );
    }
}
