package com.leedarson.platform.u202120430.devices.application.internal.commandservices;

import com.leedarson.platform.u202120430.devices.domain.model.commands.SeedSensorTypeCommand;
import com.leedarson.platform.u202120430.devices.domain.model.entities.SensorType;
import com.leedarson.platform.u202120430.devices.domain.model.valueobjects.SensorTypeName;
import com.leedarson.platform.u202120430.devices.domain.services.SensorTypeCommandService;
import com.leedarson.platform.u202120430.devices.infrastructure.persistence.jpa.repositories.SensorTypeRepository;
import org.springframework.stereotype.Service;

/**
 * Sensor Type Command Service Implementation
 * Author: Nadia Alessandra Lucas Coronel
 * Version: 1.0
 */

@Service
public class SensorTypeCommandServiceImpl implements SensorTypeCommandService {
    private final SensorTypeRepository sensorTypeRepository;

    public SensorTypeCommandServiceImpl(SensorTypeRepository sensorTypeRepository) {
        this.sensorTypeRepository = sensorTypeRepository;
    }

    /**
     * Handle the command to seed sensor types
     * @param command Command containing the details for seeding sensor types
     * @return ID of the last created sensor type
     */
    @Override
    public Long handle(SeedSensorTypeCommand command) {
        SensorTypeName[] sensorTypes = SensorTypeName.values();
        Long lastId = null;

        for (SensorTypeName typeName : sensorTypes) {
            if (!sensorTypeRepository.existsByName(typeName)) {
                SensorType sensorType = new SensorType(typeName);
                sensorTypeRepository.save(sensorType);
                lastId = sensorType.getId();
            }
        }
        return lastId;
    }
}