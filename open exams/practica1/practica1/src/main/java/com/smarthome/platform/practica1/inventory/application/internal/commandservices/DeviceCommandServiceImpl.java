package com.smarthome.platform.practica1.inventory.application.internal.commandservices;

import com.smarthome.platform.practica1.inventory.domain.model.aggregates.Device;
import com.smarthome.platform.practica1.inventory.domain.model.commands.CreateDeviceCommand;
import com.smarthome.platform.practica1.inventory.domain.model.commands.UpdateDeviceCommand;
import com.smarthome.platform.practica1.inventory.domain.model.valueobjects.InstallationDate;
import com.smarthome.platform.practica1.inventory.domain.model.valueobjects.Model;
import com.smarthome.platform.practica1.inventory.domain.model.valueobjects.SerialNumber;
import com.smarthome.platform.practica1.inventory.domain.model.valueobjects.Status;
import com.smarthome.platform.practica1.inventory.domain.services.DeviceCommandService;
import com.smarthome.platform.practica1.inventory.infrastructure.persistence.jpa.repositories.DeviceRepository;
import com.smarthome.platform.practica1.shared.infrastructure.persistence.jpa.repositories.DeviceTypeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeviceCommandServiceImpl implements DeviceCommandService {
    private final DeviceRepository deviceRepository;
    private final DeviceTypeRepository deviceTypeRepository;

    public DeviceCommandServiceImpl(DeviceRepository deviceRepository, DeviceTypeRepository deviceTypeRepository) {
        this.deviceRepository = deviceRepository;
        this.deviceTypeRepository = deviceTypeRepository;
    }

    @Override
    public Optional<Device> handle(CreateDeviceCommand command) {
        // check if device type exists
        var deviceType = deviceTypeRepository.findByType(command.deviceType().toUpperCase())
                .orElseThrow(() -> new IllegalArgumentException("Device type not found"));

        var serialNumber = new SerialNumber(command.serialNumber());
        var model = new Model(command.model());
        var installationDate = new InstallationDate(command.installationDate());
        var status = new Status(command.status());

        var device = new Device(serialNumber, model, deviceType, installationDate, status);
        try {
            deviceRepository.save(device);
        } catch(Exception e) {
            throw new IllegalArgumentException("Error saving device: " + e.getMessage());
        }
        return Optional.of(device);
    }

    @Override
    public Optional<Device> handle(UpdateDeviceCommand command) {
        // check if device exists
        var device = deviceRepository.findById(command.id())
                .orElseThrow(() -> new IllegalArgumentException("Device not found"));

        // check if device type exists
        var deviceType = deviceTypeRepository.findByType(command.deviceType().toUpperCase())
                .orElseThrow(() -> new IllegalArgumentException("Device type not found"));

        var serialNumber = new SerialNumber(command.serialNumber());
        var model = new Model(command.model());
        var installationDate = new InstallationDate(command.installationDate());
        var status = new Status(command.status());

        device.update(serialNumber, model, deviceType, installationDate, status);
        try {
            deviceRepository.save(device);
        } catch(Exception e) {
            throw new IllegalArgumentException("Error updating device: " + e.getMessage());
        }
        return Optional.of(device);
    }
}
