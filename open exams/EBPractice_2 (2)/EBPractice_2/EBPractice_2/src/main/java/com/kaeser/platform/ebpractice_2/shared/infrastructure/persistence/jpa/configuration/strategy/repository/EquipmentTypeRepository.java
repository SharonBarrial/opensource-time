package com.kaeser.platform.ebpractice_2.shared.infrastructure.persistence.jpa.configuration.strategy.repository;

import com.kaeser.platform.ebpractice_2.shared.domain.model.entities.EquipmentType;
import com.kaeser.platform.ebpractice_2.shared.domain.model.valueObjects.EquipmentTypeName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
public interface EquipmentTypeRepository extends JpaRepository<EquipmentType, Long> {
    boolean existsByType(EquipmentTypeName name);
    Optional<EquipmentType> findByType(EquipmentTypeName type);
}
