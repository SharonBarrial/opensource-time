package com.leedarson.platform.u202120430.devices.domain.model.valueobjects;

/**
 * @author Nadia Alessandra Lucas Coronel
 * @version 1.0
 */
public record ReferenceImageUrl(String referenceImageUrl) {
    public ReferenceImageUrl {
        if (referenceImageUrl == null || referenceImageUrl.isBlank()) {
            throw new IllegalArgumentException("Reference Image Url must not be null or empty");
        }
    }
}
