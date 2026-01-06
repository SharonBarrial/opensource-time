package com.isa.platform.u202210749.inventory.infrastructure.persistence.jpa.repositories;

import com.isa.platform.u202210749.inventory.domain.model.entities.MonitoringLevel;
import com.isa.platform.u202210749.inventory.domain.model.valueobjects.MonitoringLevels;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MonitoringLevelRepository extends JpaRepository<MonitoringLevel, Long> {
    boolean existsByName(MonitoringLevels name);
}
