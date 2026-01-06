package org.hign.platform.u202120418.assessment.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Language score value object
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
@Embeddable
public record LanguageScore(Integer languageScore) {
    public LanguageScore {
        if (languageScore == null || languageScore <= 0 || languageScore >= 9) {
            throw new IllegalArgumentException("Language score must be between 0 and 100");
        }
    }
}
