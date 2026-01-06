package com.leedarson.platform.u202120430.devices.domain.services;

import com.leedarson.platform.u202120430.devices.domain.model.commands.SeedSensorTypeCommand;

/**
 * @author Nadia Alessandra Lucas Coronel
 * @version 1.0
 */
public interface SensorTypeCommandService {
    Long handle(SeedSensorTypeCommand command);
}
