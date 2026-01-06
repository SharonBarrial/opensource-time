package com.leedarson.platform.u20221a322.devices.application.internal.commandservices;

import com.leedarson.platform.u20221a322.devices.domain.model.aggregates.Sensor;
import com.leedarson.platform.u20221a322.devices.domain.model.commands.CreateSensorCommand;
import com.leedarson.platform.u20221a322.devices.domain.services.SensorCommandService;
import com.leedarson.platform.u20221a322.devices.infrastructure.persistence.jpa.repositories.SensorRepository;
import com.leedarson.platform.u20221a322.devices.infrastructure.persistence.jpa.repositories.SensorTypeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: leedarson
 * Date: 12/06/24 @ 01:44
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
     * @param command CreateSensorCommand
     * @return Optional<Sensor>
     * @throws RuntimeException if sensor with name, sensorTypeId and manufacturer already exists
     * @throws RuntimeException if SensorType with id does not exist
     * @summary Checks if a sensor with the same name, sensorTypeId, and manufacturer already exists. If it does, an exception is thrown. Also verifies if the sensorTypeId exists, if not, an exception is thrown.
     * @author Alex Avila Asto
     */
    @Override
    public Optional<Sensor> handle(CreateSensorCommand command) {
        if (sensorRepository.existsByNameAndSensorTypeIdAndManufacturer(command.name(), command.sensorTypeId(), command.manufacturer())) {
            throw new RuntimeException("Sensor with name, sensorTypeId and manufacturer already exists");
        }
        if (!sensorTypeRepository.existsById(command.sensorTypeId())) {
            throw new RuntimeException("SensorType with id does not exist");
        }
        var sensor = new Sensor(command);
        return Optional.of(sensorRepository.save(sensor));
    }
}
