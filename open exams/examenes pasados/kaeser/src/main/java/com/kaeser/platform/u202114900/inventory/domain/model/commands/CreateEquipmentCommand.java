package com.kaeser.platform.u202114900.inventory.domain.model.commands;

/**
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */
public record CreateEquipmentCommand(
        String model,
        String equipmentTypeName
) {
}
