package com.kaeser.platform.ebpractice_2.analytics.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
@Embeddable
public record ThresholdMaximum(Double thresholdMaximum) {

    public ThresholdMaximum {
                if (thresholdMaximum == null) {
                    throw new IllegalArgumentException("ThresholdMaximum cannot be null");
                }
                if (thresholdMaximum < 0) {
                    throw new IllegalArgumentException("ThresholdMaximum cannot be negative");
                }
    }

    public Double getThresholdMaximum() {
                return thresholdMaximum;
    }
}
