package com.smarthome.platform.practica1.inventory.infrastructure.persistence.jpa.repositories;

import com.smarthome.platform.practica1.inventory.domain.model.aggregates.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
