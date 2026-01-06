package com.agrimarket.inventories.domain.services;

import com.agrimarket.inventories.domain.model.aggregates.Equipment;
import com.agrimarket.inventories.domain.model.queries.GetEquipmentByIdQuery;

import java.util.Optional;

/**
 * This interface represents the service that handles the query of getting an equipment by its id.
 * It has a method that receives a GetEquipmentByIdQuery and returns an Optional of Equipment.
 * If the equipment is found, it returns an Optional with the equipment, otherwise it returns an empty Optional.
 * This interface is implemented by EquipmentQueryServiceImpl.
 * @author Sharon Antuanet Ivet Barrial Marin
 * @version 1.0
 */

public interface EquipmentQueryService {
    Optional<Equipment> handle(GetEquipmentByIdQuery query);
}
