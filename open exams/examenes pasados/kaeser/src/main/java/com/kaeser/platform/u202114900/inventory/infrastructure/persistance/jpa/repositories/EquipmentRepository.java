package com.kaeser.platform.u202114900.inventory.infrastructure.persistance.jpa.repositories;

import com.kaeser.platform.u202114900.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.u202114900.inventory.domain.model.valueobjects.MaterialSerialNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    boolean existsByMaterialSerialNumber(MaterialSerialNumber materialSerialNumber);
}
