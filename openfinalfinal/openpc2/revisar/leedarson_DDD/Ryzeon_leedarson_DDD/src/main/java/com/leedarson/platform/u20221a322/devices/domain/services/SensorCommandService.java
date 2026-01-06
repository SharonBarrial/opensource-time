package com.leedarson.platform.u20221a322.devices.domain.services;

import com.leedarson.platform.u20221a322.devices.domain.model.aggregates.Sensor;
import com.leedarson.platform.u20221a322.devices.domain.model.commands.CreateSensorCommand;

import java.util.Optional;

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: leedarson
 * Date: 12/06/24 @ 01:43
 */
public interface SensorCommandService {

    Optional<Sensor> handle(CreateSensorCommand command);
}
