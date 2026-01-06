package com.smarthome.platform.practica1.analytics.infrastructure.persistence.jpa.repositories;

import com.smarthome.platform.practica1.analytics.domain.model.aggregates.PerformanceIndicator;
import com.smarthome.platform.practica1.shared.domain.model.entities.DeviceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PerformanceIndicatorRepository extends JpaRepository<PerformanceIndicator, Long> {
    Optional<PerformanceIndicator> findByDeviceType(DeviceType deviceType);
}
