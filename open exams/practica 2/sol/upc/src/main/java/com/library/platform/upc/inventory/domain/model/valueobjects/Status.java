package com.library.platform.upc.inventory.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Status(String status) {
    public Status {
        if (status.length() > 10) {
            throw new IllegalArgumentException("Status must be maximum 10 characters");
        }
        if (!status.equals("AVAILABLE") && !status.equals("BORROWED")) {
            throw new IllegalArgumentException("Status should be either AVAILABLE or BORROWED");
        }
    }
}