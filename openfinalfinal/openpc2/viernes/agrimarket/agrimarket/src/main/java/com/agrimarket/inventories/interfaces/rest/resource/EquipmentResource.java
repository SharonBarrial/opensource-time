package com.agrimarket.inventories.interfaces.rest.resource;

/**
 * How the created response should look like
 * @version 1.0
 * @author Sharon Antuanet Ivet Barrial Marin
 */
public record EquipmentResource(
        Long id,
        String name,
        Long categoryId,
        String description,
        String referenceImageUrl) {
}
