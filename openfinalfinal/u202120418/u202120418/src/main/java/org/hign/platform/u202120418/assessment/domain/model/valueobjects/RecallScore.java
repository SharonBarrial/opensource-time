package org.hign.platform.u202120418.assessment.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
@Embeddable
public record RecallScore(Integer recallScore) {
    public RecallScore {
        if (recallScore == null || recallScore <= 0 || recallScore >= 3) {
            throw new IllegalArgumentException("Recall score must be between 0 and 100");
        }
    }
}
