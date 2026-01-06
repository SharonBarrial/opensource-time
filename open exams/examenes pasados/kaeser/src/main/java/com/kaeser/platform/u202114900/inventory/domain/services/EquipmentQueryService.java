package com.kaeser.platform.u202114900.inventory.domain.services;

import com.kaeser.platform.u202114900.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.u202114900.inventory.domain.model.queries.GetEquipmentById;
import com.kaeser.platform.u202114900.inventory.domain.model.queries.GetEquipmentTypeByName;

import java.util.Optional;

/**
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */
public interface EquipmentQueryService {
    Optional<Equipment> handle(GetEquipmentById query);
    Optional<Equipment>  handle(GetEquipmentTypeByName query);
}
