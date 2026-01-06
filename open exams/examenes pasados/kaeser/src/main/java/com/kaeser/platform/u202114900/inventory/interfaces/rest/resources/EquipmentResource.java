package com.kaeser.platform.u202114900.inventory.interfaces.rest.resources;

/**
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */
public record EquipmentResource(
        Long equipmentId,
        String materialSerialNumber,
        String model,
        String equipmentTypeName
) {
}
