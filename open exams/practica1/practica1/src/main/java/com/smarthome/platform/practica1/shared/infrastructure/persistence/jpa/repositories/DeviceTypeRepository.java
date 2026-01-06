package com.smarthome.platform.practica1.shared.infrastructure.persistence.jpa.repositories;

import com.smarthome.platform.practica1.shared.domain.model.entities.DeviceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeviceTypeRepository extends JpaRepository<DeviceType, Long> {
    Optional<DeviceType> findByType(String type);
}
