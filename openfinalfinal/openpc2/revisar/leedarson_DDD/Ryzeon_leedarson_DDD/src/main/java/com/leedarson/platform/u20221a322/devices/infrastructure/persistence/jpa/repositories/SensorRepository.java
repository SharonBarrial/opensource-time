package com.leedarson.platform.u20221a322.devices.infrastructure.persistence.jpa.repositories;

import com.leedarson.platform.u20221a322.devices.domain.model.aggregates.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: leedarson
 * Date: 12/06/24 @ 01:45
 */
@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {

    /**
     * Query to check if the sensor exists by name and sensor type id and manufacturer
     * @param name Sensor name
     * @param sensorTypeId Sensor type id
     * @param manufacturer Sensor manufacturer
     * @return boolean
     * @author Alex Avila Asto
     */
    boolean existsByNameAndSensorTypeIdAndManufacturer(String name, Long sensorTypeId, String manufacturer);
}
