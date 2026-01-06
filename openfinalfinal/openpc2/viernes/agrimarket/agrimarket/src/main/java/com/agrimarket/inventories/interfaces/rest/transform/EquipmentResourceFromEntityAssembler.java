package com.agrimarket.inventories.interfaces.rest.transform;

import com.agrimarket.inventories.domain.model.aggregates.Equipment;
import com.agrimarket.inventories.interfaces.rest.resource.EquipmentResource;

public class EquipmentResourceFromEntityAssembler {
    public static EquipmentResource toResourceFromEntity(Equipment equipment) {
        return new EquipmentResource(
                equipment.getId(),
                equipment.getName(),
                equipment.getCategoryType().getId(),
                equipment.getDescription(),
                equipment.getReferenceImageUrl());
    }
}
