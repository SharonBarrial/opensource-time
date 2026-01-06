package com.kaeser.platform.u202114900.analytics.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * ThresholdMinimum value object
 * <p>
 *     This class represents the minimum threshold of a measurable indicator.
 *     It contains the minimum threshold of the measurable indicator.
 *     It also contains the getter for the minimum threshold of the measurable indicator.
 * </p>
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */

@Embeddable
public record ThresholdMinimum(Double thresholdMinimum) {
    public ThresholdMinimum {
        if (thresholdMinimum == null) {
            throw new IllegalArgumentException("Threshold minimum must not be null");
        }
        if (thresholdMinimum < 0) {
            throw new IllegalArgumentException("Threshold minimum must not be negative");
        }
    }

    public Double GetThresholdMinimum() {
        return thresholdMinimum;
    }
}
