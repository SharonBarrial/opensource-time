package com.smarthomemanagement.platform.tareaopensem14.inventory.domain.model.valueobjects;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */
public record Status(String status) {
    public Status {
        if (status == null || status.isBlank() || status.length() > 10) {
            throw new IllegalArgumentException("Status must not be null or empty");
        }
        if (!status.equals("ACTIVE") && !status.equals("INACTIVE")) {
            throw new IllegalArgumentException("Status must be either ACTIVE or INACTIVE");
        }
    }
}
