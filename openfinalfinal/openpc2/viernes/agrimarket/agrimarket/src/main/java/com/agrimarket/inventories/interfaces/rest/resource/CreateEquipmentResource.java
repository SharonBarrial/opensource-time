package com.agrimarket.inventories.interfaces.rest.resource;


import jakarta.validation.constraints.NotNull;

/**
 * Resource record for creating an equipment.
 * @version 1.0
 * @author Sharon Antuanet Ivet Barrial Marin
 */

public record CreateEquipmentResource(
        @NotNull String name,
        @NotNull Long categoryId,
        @NotNull String description,
        @NotNull String referenceImageUrl
) {
}
