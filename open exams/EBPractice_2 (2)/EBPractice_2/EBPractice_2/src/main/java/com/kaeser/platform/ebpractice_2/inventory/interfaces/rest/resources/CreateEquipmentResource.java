package com.kaeser.platform.ebpractice_2.inventory.interfaces.rest.resources;

/**
 * This class is a resource class that will be used to create equipment.
 *
 * @author Fiorella Jarama Peñaloza
 */
public record CreateEquipmentResource(
        String model,
        String equipmentTypeName
) {
}
