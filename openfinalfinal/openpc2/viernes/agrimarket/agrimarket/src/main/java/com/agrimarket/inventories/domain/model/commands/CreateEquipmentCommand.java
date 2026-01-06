package com.agrimarket.inventories.domain.model.commands;


/**
 * Command use to create an Equipment
 * @author Sharon Antuanet Ivet Barrial Marin
 * @version 1.0
 */
public record CreateEquipmentCommand(
        String name,
        Long categoryId,
        String description,
        String referenceImageUrl
) {
}
