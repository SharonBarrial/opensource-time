package com.leedarson.platform.u202120430.devices.infrastructure.persistence.jpa.repositories;

import com.leedarson.platform.u202120430.devices.domain.model.aggregates.Sensor;
import com.leedarson.platform.u202120430.devices.domain.model.entities.SensorType;
import com.leedarson.platform.u202120430.devices.domain.model.valueobjects.Manufacturer;
import com.leedarson.platform.u202120430.devices.domain.model.valueobjects.Name;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Sensor Repository for the Sensor entity.
 * @author Nadia Alessandra Lucas Coronel
 * @version 1.0
 */

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {
    boolean existsByNameAndSensorTypeAndManufacturer(Name name, SensorType sensorType, Manufacturer manufacturer);
}
