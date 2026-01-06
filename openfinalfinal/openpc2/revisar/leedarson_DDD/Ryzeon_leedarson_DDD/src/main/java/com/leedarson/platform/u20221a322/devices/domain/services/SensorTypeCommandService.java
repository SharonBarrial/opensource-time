package com.leedarson.platform.u20221a322.devices.domain.services;

import com.leedarson.platform.u20221a322.devices.domain.model.commands.SeedSensorTypesCommand;

import java.util.Optional;

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: leedarson
 * Date: 12/06/24 @ 01:12
 */
public interface SensorTypeCommandService {
    
    void handle(SeedSensorTypesCommand command);
}
