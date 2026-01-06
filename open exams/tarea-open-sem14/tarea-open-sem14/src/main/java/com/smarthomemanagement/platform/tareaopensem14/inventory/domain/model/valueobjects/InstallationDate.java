package com.smarthomemanagement.platform.tareaopensem14.inventory.domain.model.valueobjects;

import java.time.LocalDate;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */
public record InstallationDate(LocalDate installationDate) {
    public InstallationDate {
        if (installationDate == null) {
            throw new IllegalArgumentException("Installation date must not be null");
        }
        if (installationDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Installation date must be today or in the future");
        }
    }
}
