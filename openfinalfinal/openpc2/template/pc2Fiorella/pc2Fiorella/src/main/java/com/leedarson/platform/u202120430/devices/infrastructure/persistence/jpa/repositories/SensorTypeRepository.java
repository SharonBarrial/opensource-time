package com.leedarson.platform.u202120430.devices.infrastructure.persistence.jpa.repositories;

import com.leedarson.platform.u202120430.devices.domain.model.entities.SensorType;
import com.leedarson.platform.u202120430.devices.domain.model.valueobjects.SensorTypeName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA Repository for SensorType entity.
 * @author Nadia Alessandra Lucas Coronel
 * @version 1.0
 */

@Repository
public interface SensorTypeRepository extends JpaRepository<SensorType, Long> {
    boolean existsByName(SensorTypeName name);
}
