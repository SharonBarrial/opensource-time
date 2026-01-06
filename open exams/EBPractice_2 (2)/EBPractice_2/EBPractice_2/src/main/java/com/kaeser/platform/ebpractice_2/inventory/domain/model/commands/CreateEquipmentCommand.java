package com.kaeser.platform.ebpractice_2.inventory.domain.model.commands;

/**
 * CreateEquipmentCommand - Represents the command to create equipment.
 *
 * @author Fiorella Jarama Peñaloza
 */
public record CreateEquipmentCommand(
        String model,
        String equipmentTypeName
) { }
