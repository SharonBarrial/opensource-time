package com.agrimarket.inventories.interfaces.rest.resource;

public record CategoryTypeResource(
        Long id,
        String name,
        String description,
        Long parentId,
        String referenceImageUrl) {
}
