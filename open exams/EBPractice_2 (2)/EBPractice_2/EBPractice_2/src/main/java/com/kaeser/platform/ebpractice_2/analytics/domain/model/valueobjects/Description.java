package com.kaeser.platform.ebpractice_2.analytics.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
@Embeddable
public record Description(String description) {

    public Description {
        if (description == null || description.isBlank()) {
            description = "No description provided";
        }
    }

    public String getDescription() {
        return description;
    }
}
