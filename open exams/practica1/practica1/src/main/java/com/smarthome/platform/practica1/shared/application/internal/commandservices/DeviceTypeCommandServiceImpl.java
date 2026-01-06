package com.smarthome.platform.practica1.shared.application.internal.commandservices;

import com.smarthome.platform.practica1.shared.domain.model.commands.CreateDeviceTypeCommand;
import com.smarthome.platform.practica1.shared.domain.model.entities.DeviceType;
import com.smarthome.platform.practica1.shared.domain.services.DeviceTypeCommandService;
import com.smarthome.platform.practica1.shared.infrastructure.persistence.jpa.repositories.DeviceTypeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeviceTypeCommandServiceImpl implements DeviceTypeCommandService {
    private final DeviceTypeRepository deviceTypeRepository;

    public DeviceTypeCommandServiceImpl(DeviceTypeRepository deviceTypeRepository) {
        this.deviceTypeRepository = deviceTypeRepository;
    }

    @Override
    public Optional<DeviceType> handle(CreateDeviceTypeCommand command) {
        var deviceType = new DeviceType(command.type());
        try {
            deviceTypeRepository.save(deviceType);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error saving device type: " + e.getMessage());
        }
        return Optional.of(deviceType);
    }

}
