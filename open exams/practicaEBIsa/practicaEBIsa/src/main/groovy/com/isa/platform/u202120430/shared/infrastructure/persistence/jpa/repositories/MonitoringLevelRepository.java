package com.isa.platform.u202120430.shared.infrastructure.persistence.jpa.repositories;

import com.isa.platform.u202120430.shared.domain.model.entities.MonitoringLevel;
import com.isa.platform.u202120430.shared.domain.model.valueobjects.MonitoringLevelName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */

@Repository
public interface MonitoringLevelRepository extends JpaRepository<MonitoringLevel, Long>{
    boolean existsByLevel(MonitoringLevelName level);
    Optional<MonitoringLevel> findByLevel(MonitoringLevelName level);
}
