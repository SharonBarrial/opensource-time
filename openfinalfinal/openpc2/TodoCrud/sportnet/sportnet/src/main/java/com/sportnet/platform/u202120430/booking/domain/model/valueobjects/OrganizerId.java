package com.sportnet.platform.u202120430.booking.domain.model.valueobjects;

public record OrganizerId(Long organizerId) {
    public OrganizerId {
        if (organizerId == null || organizerId <= 0) {
            throw new IllegalArgumentException("OrganizerId must be a positive number");
        }
    }
}
