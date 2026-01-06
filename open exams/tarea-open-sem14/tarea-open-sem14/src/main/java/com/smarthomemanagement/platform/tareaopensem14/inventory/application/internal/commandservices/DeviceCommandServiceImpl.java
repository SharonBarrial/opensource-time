package com.smarthomemanagement.platform.tareaopensem14.inventory.application.internal.commandservices;

import com.smarthomemanagement.platform.tareaopensem14.inventory.domain.exceptions.DeviceTypeNotFoundException;
import com.smarthomemanagement.platform.tareaopensem14.inventory.domain.model.aggregates.Device;
import com.smarthomemanagement.platform.tareaopensem14.inventory.domain.model.commands.CreateDeviceCommand;
import com.smarthomemanagement.platform.tareaopensem14.inventory.domain.model.valueobjects.SerialNumber;
import com.smarthomemanagement.platform.tareaopensem14.inventory.domain.services.DeviceCommandService;
import com.smarthomemanagement.platform.tareaopensem14.inventory.infrastructure.persistence.jpa.repositories.DeviceRepository;
import com.smarthomemanagement.platform.tareaopensem14.shared.domain.model.entities.DeviceType;
import com.smarthomemanagement.platform.tareaopensem14.shared.infrastructure.persistence.jpa.repositories.DeviceTypeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */

@Service
public class DeviceCommandServiceImpl implements DeviceCommandService {
    private final DeviceRepository deviceRepository;
    private final DeviceTypeRepository deviceTypeRepository;

    public DeviceCommandServiceImpl(DeviceRepository deviceRepository, DeviceTypeRepository deviceTypeRepository) {
        this.deviceRepository = deviceRepository;
        this.deviceTypeRepository = deviceTypeRepository;
    }


    @Override
    public Long handle(CreateDeviceCommand command) {
        //Check if device type exists
        Optional<DeviceType> optionalDeviceType = deviceTypeRepository.findById(command.deviceTypeId());
        DeviceType deviceType = optionalDeviceType.orElseThrow(() -> new DeviceTypeNotFoundException(command.deviceTypeId()));

        //Validate if serial number already exists
        SerialNumber serialNumber = new SerialNumber(command.serialNumber());
        if(deviceRepository.existsBySerialNumber(serialNumber)) {
            throw new IllegalArgumentException("Device with serial number already exists");
        }

        //Create and save the device
        Device device = new Device(command, deviceType);
        try {
            deviceRepository.save(device);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error saving device");
        }
        return device.getId();
    }
}
