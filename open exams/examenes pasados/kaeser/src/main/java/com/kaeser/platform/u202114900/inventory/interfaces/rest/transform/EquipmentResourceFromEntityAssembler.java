package com.kaeser.platform.u202114900.inventory.interfaces.rest.transform;

import com.kaeser.platform.u202114900.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.u202114900.inventory.interfaces.rest.resources.EquipmentResource;

/**
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */
public class EquipmentResourceFromEntityAssembler {
    public static EquipmentResource toResourceFromEntity(Equipment equipment) {
        return new EquipmentResource(
                equipment.getId(),
                equipment.getMaterialSerialNumber(),
                equipment.getModel(),
                equipment.getEquipmentTypeName());
    }
}
