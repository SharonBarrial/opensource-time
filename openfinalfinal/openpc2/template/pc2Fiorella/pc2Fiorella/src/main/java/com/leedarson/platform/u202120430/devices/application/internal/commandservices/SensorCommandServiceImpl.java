package com.leedarson.platform.u202120430.devices.application.internal.commandservices;

import com.leedarson.platform.u202120430.devices.domain.model.commands.CreateSensorCommand;
import com.leedarson.platform.u202120430.devices.domain.model.entities.SensorType;
import com.leedarson.platform.u202120430.devices.domain.model.valueobjects.Manufacturer;
import com.leedarson.platform.u202120430.devices.domain.model.valueobjects.Name;
import com.leedarson.platform.u202120430.devices.domain.services.SensorCommandService;
import com.leedarson.platform.u202120430.devices.infrastructure.persistence.jpa.repositories.SensorRepository;
import com.leedarson.platform.u202120430.devices.infrastructure.persistence.jpa.repositories.SensorTypeRepository;
import org.springframework.stereotype.Service;
import com.leedarson.platform.u202120430.devices.domain.model.aggregates.Sensor;

/**
 * Sensor Command Service Implementation
 * @author Nadia Alessandra Lucas Coronel
 * @version 1.0
 */

@Service
public class SensorCommandServiceImpl implements SensorCommandService {
    private final SensorRepository sensorRepository;
    private final SensorTypeRepository sensorTypeRepository;

    public SensorCommandServiceImpl(SensorRepository sensorRepository, SensorTypeRepository sensorTypeRepository) {
        this.sensorRepository = sensorRepository;
        this.sensorTypeRepository = sensorTypeRepository;
    }

    /**
     * Handle the command to create sensor
     * @param command
     * @return
     */
    @Override
    public Long handle(CreateSensorCommand command) {
        var sensorType = sensorTypeRepository.findById(command.sensorTypeId());
        if(sensorType.isEmpty()) {
            throw new IllegalArgumentException("Sensor type not found");
        }

        Name name = new Name(command.name());
        Manufacturer manufacturer = new Manufacturer(command.manufacturer());

        if(sensorRepository.existsByNameAndSensorTypeAndManufacturer(name, sensorType.get(), manufacturer)) {
            throw new IllegalArgumentException("Sensor with name, type and manufacturer already exists");
        }

        var sensor = new Sensor(command, sensorType.get());
        try {
            sensorRepository.save(sensor);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving sensor: " + e.getMessage());
        }
        return sensor.getId();
    }
}
