package org.hign.platform.u202120418.personnel.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

/**
 * Clase que representa el identificador del proveedor nacional.
 * Garantiza que el valor proporcionado sea un UUID de versión 4 válido.
 * @autor Fiorella Jarama Peñaloza
 * @version 1.0
 */
@Embeddable
public record NationalProviderIdentifier(String nationalProviderIdentifier) {
    public NationalProviderIdentifier {
        if (nationalProviderIdentifier == null || nationalProviderIdentifier.isBlank()) {
            throw new IllegalArgumentException("National Provider Identifier cannot be null or blank");
        }
        if (!isValidUUIDv4(nationalProviderIdentifier)) {
            throw new IllegalArgumentException("Invalid UUID version 4 format");
        }
    }

    private static boolean isValidUUIDv4(String value) {
        try {
            UUID uuid = UUID.fromString(value);
            return uuid.version() == 4;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
