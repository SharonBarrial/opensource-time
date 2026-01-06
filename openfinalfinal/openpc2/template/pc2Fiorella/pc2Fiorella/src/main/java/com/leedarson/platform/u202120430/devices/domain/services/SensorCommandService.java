package com.leedarson.platform.u202120430.devices.domain.services;

import com.leedarson.platform.u202120430.devices.domain.model.commands.CreateSensorCommand;

/**
 * Sensor command service
 * @author Nadia Alessandra Lucas Coronel
 * @version 1.0
 */
public interface SensorCommandService {
    Long handle(CreateSensorCommand command);
}
