package com.kaeser.platform.u202114900.analytics.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.sql.Struct;

/**
 * Description value object
 * <p>
 *     This class represents the description of a measurable indicator.
 *     It contains the description of the measurable indicator.
 *     It also contains the getter for the description of the measurable indicator.
 *     It contains a constructor with a description parameter.
 *     It is used to create a new instance of Description.
 *     It is used by the MeasurableIndicator entity.
 *     It is used to create a new instance of Description.
 * </p>
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */

@Embeddable
public record Description(String description) {
    public Description {
        if (description == null || description.isBlank()) {
            description = "No description available or provided.";
        }
    }

    public String GetDescription() {
        return description;
    }
}
