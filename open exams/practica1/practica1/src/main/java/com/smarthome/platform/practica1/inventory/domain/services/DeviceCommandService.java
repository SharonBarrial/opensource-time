package com.smarthome.platform.practica1.inventory.domain.services;

import com.smarthome.platform.practica1.inventory.domain.model.aggregates.Device;
import com.smarthome.platform.practica1.inventory.domain.model.commands.CreateDeviceCommand;
import com.smarthome.platform.practica1.inventory.domain.model.commands.UpdateDeviceCommand;

import java.util.Optional;

public interface DeviceCommandService {
    Optional<Device> handle(CreateDeviceCommand command);
    Optional<Device> handle(UpdateDeviceCommand command);
}
