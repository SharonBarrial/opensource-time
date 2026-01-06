package com.smarthome.platform.practica1.shared.domain.services;

import com.smarthome.platform.practica1.shared.domain.model.commands.CreateDeviceTypeCommand;
import com.smarthome.platform.practica1.shared.domain.model.entities.DeviceType;

import java.util.Optional;

public interface DeviceTypeCommandService {
    Optional<DeviceType> handle(CreateDeviceTypeCommand command);
}
