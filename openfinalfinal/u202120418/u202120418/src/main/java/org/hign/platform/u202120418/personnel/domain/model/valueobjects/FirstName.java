package org.hign.platform.u202120418.personnel.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
@Embeddable
public record FirstName(String firstName) {
    public FirstName {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name cannot be null or empty");
        }
    }
}
