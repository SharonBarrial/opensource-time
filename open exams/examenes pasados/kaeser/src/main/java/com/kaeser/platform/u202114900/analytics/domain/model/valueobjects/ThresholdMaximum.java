package com.kaeser.platform.u202114900.analytics.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * ThresholdMaximum value object
 * <p>
 *     This class represents the maximum threshold of a measurable indicator.
 *     It contains the maximum threshold of the measurable indicator.
 *     It also contains the getter for the maximum threshold of the measurable indicator.
 * </p>
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */

@Embeddable
public record ThresholdMaximum(Double thresholdMaximum) {
    public ThresholdMaximum {
        if (thresholdMaximum == null) {
            throw new IllegalArgumentException("Threshold maximum must not be null");
        }
        if (thresholdMaximum < 0) {
            throw new IllegalArgumentException("Threshold maximum must not be negative");
        }
    }

    public Double GetThresholdMaximum() {
        return thresholdMaximum;
    }
}
