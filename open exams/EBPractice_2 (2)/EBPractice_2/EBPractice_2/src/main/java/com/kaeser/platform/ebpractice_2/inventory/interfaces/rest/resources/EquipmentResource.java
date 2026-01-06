package com.kaeser.platform.ebpractice_2.inventory.interfaces.rest.resources;

/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
public record EquipmentResource(
        Long equipmentId,
        String materialSerialNumber,
        String model,
        String equipmentTypeName
) {
}
