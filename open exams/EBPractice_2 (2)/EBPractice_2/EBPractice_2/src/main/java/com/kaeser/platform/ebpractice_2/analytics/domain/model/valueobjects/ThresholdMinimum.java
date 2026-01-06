package com.kaeser.platform.ebpractice_2.analytics.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
@Embeddable
public record ThresholdMinimum(Double thresholdMinimum) {

    public ThresholdMinimum {
            if (thresholdMinimum == null) {
                throw new IllegalArgumentException("ThresholdMinimum cannot be null");
            }
            if (thresholdMinimum < 0) {
                throw new IllegalArgumentException("ThresholdMinimum cannot be negative");
            }
    }

    public Double getThresholdMinimum() {
            return thresholdMinimum;
    }
}
