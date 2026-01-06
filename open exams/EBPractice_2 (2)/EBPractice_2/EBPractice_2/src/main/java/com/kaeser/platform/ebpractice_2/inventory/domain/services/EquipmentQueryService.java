package com.kaeser.platform.ebpractice_2.inventory.domain.services;

import com.kaeser.platform.ebpractice_2.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.ebpractice_2.inventory.domain.model.queries.GetEquipmentById;
import com.kaeser.platform.ebpractice_2.inventory.domain.model.queries.GetEquipmentTypeByName;

import java.util.Optional;

/**
 * @author Fiorella Jarama Peñaloza
 * @version 2.0
 */
public interface EquipmentQueryService {
    Optional<Equipment> handle(GetEquipmentById query);
    Optional<Equipment>  handle(GetEquipmentTypeByName query);
}
