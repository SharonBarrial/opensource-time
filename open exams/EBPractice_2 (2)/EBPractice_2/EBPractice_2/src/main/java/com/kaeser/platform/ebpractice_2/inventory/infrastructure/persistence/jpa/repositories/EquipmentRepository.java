package com.kaeser.platform.ebpractice_2.inventory.infrastructure.persistence.jpa.repositories;

import com.kaeser.platform.ebpractice_2.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.ebpractice_2.inventory.domain.model.valueobjects.MaterialSerialNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * EquipmentRepository - Represents the repository of the equipment.
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    boolean existsByMaterialSerialNumber(MaterialSerialNumber materialSerialNumber);
}
