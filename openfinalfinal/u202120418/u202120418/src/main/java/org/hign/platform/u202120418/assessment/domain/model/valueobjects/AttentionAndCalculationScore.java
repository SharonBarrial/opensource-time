package org.hign.platform.u202120418.assessment.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
@Embeddable
public record AttentionAndCalculationScore(Integer attentionAndCalculationScore) {
    public AttentionAndCalculationScore {
        if (attentionAndCalculationScore == null || attentionAndCalculationScore <= 0 || attentionAndCalculationScore >= 5) {
            throw new IllegalArgumentException("Attention and calculation score cannot be null or negative");
        }
    }
}
