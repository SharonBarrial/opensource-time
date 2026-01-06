package com.kaeser.platform.u202114900.shared.infrastructure.persistence.jpa.configuration.strategy.repositories;

import com.kaeser.platform.u202114900.shared.domain.model.entities.EquipmentType;
import com.kaeser.platform.u202114900.shared.domain.model.valueobjects.EquipmentTypeName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */
public interface EquipmentTypeRepository extends JpaRepository<EquipmentType, Long> {
    boolean existsByType(EquipmentTypeName name);
    Optional<EquipmentType> findByType(EquipmentTypeName type);
}
