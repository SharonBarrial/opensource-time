package org.hign.platform.u202120418.assessment.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
@Embeddable
public record RegistrationScore(Integer registrationScore) {
    public RegistrationScore {
        if (registrationScore == null || registrationScore <= 0 || registrationScore >= 3) {
            throw new IllegalArgumentException("Registration score cannot be null, negative, or above 3");
        }
    }
}
