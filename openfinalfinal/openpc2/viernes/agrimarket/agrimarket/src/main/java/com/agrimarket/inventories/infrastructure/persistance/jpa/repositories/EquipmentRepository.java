package com.agrimarket.inventories.infrastructure.persistance.jpa.repositories;


import com.agrimarket.inventories.domain.model.aggregates.Equipment;
import com.agrimarket.inventories.domain.model.valueobjects.Name;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA Repository for Equipment entity.
 * @version 1.0
 * @author Sharon Antuanet Ivet Barrial Marin
 */

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    boolean existsByName(Name name);
}
