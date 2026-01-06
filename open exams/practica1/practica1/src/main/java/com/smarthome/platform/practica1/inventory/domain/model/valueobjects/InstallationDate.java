package com.smarthome.platform.practica1.inventory.domain.model.valueobjects;

import java.util.Date;

public record InstallationDate(Date installationDate) {
    public InstallationDate {
        if (installationDate == null) {
            throw new IllegalArgumentException("Installation date cannot be null");
        }
        // Check if the installation date is in the past
        if (installationDate.before(new Date())) {
            throw new IllegalArgumentException("Installation date cannot be in the past");
        }
    }
}
