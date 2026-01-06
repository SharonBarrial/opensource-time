package com.leedarson.platform.u20221a322.devices.infrastructure.persistence.jpa.repositories;

import com.leedarson.platform.u20221a322.devices.domain.model.entities.SensorType;
import com.leedarson.platform.u20221a322.devices.domain.model.valueobjects.SensorTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: leedarson
 * Date: 12/06/24 @ 01:14
 */
@Repository
public interface SensorTypeRepository extends JpaRepository<SensorType, Long> {

    /**
     * Query to check if the sensor type exists by name
     * @param name SensorTypes
     * @return boolean
     * @author Alex Avila Asto
     */
    boolean existsByName(SensorTypes name);
}
