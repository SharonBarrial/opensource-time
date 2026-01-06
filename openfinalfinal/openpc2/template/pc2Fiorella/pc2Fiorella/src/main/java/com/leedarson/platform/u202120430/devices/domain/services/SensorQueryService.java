package com.leedarson.platform.u202120430.devices.domain.services;

import com.leedarson.platform.u202120430.devices.domain.model.aggregates.Sensor;
import com.leedarson.platform.u202120430.devices.domain.model.queries.GetSensorByIdQuery;

import java.util.Optional;

/**
 * @author Nadia Alessandra Lucas Coronel
 * @version 1.0
 */
public interface SensorQueryService {
    Optional<Sensor> handle(GetSensorByIdQuery query);
}
