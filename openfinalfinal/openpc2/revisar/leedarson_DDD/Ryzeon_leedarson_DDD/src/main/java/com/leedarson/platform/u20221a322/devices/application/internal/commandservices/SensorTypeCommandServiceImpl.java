package com.leedarson.platform.u20221a322.devices.application.internal.commandservices;

import com.leedarson.platform.u20221a322.devices.domain.model.commands.SeedSensorTypesCommand;
import com.leedarson.platform.u20221a322.devices.domain.model.entities.SensorType;
import com.leedarson.platform.u20221a322.devices.domain.model.valueobjects.SensorTypes;
import com.leedarson.platform.u20221a322.devices.domain.services.SensorTypeCommandService;
import com.leedarson.platform.u20221a322.devices.infrastructure.persistence.jpa.repositories.SensorTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: leedarson
 * Date: 12/06/24 @ 01:13
 */
@Service
public class SensorTypeCommandServiceImpl implements SensorTypeCommandService {

    private final SensorTypeRepository sensorTypeRepository;

    public SensorTypeCommandServiceImpl(SensorTypeRepository sensorTypeRepository) {
        this.sensorTypeRepository = sensorTypeRepository;
    }

    /**
     * @summary Iterate over SensorTypes and check if they exist in the database, if not, save them
     * @param command SeedSensorTypesCommand
     * @author Alex Avila Asto
     */
    @Override
    public void handle(SeedSensorTypesCommand command) {
        Arrays.stream(SensorTypes.values()).forEach(name -> {
            if (!sensorTypeRepository.existsByName(name)) {
                sensorTypeRepository.save(new SensorType(name));
            }
        });
    }
}
