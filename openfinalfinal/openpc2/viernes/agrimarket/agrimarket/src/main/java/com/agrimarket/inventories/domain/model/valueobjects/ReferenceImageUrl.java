package com.agrimarket.inventories.domain.model.valueobjects;

/**
 * @author Sharon Antuanet Ivet Barrial Marin
 * @version 1.0
 */

public record ReferenceImageUrl(String referenceImageUrl) {
    public ReferenceImageUrl {
        if (referenceImageUrl == null || referenceImageUrl.isBlank()) {
            throw new IllegalArgumentException("Reference Image Url must not be null or empty");
        }
    }
}
