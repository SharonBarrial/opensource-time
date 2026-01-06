package org.hign.platform.u202120418.assessment.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * OrientationScore - Value object for orientation score
 *
 * @author Fiorella Jarama Peñaloza
 */
@Embeddable
public record OrientationScore (Integer orientationScore) {
    public OrientationScore {
        if (orientationScore == null || orientationScore <= 0 || orientationScore >= 10) {
            throw new IllegalArgumentException("Orientation score must be between 0 and 10");
        }
    }
}
