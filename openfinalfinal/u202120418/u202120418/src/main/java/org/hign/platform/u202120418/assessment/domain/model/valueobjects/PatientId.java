package org.hign.platform.u202120418.assessment.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
@Embeddable
public record PatientId(Long patientId) {
    public PatientId {
        if (patientId == null) {
            throw new IllegalArgumentException("PatientId cannot be null");
        }
    }
}
