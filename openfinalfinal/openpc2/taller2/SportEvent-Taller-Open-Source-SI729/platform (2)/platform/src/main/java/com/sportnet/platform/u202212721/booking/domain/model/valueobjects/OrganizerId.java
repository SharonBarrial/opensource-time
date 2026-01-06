package com.sportnet.platform.u202212721.booking.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Value object for the OrganizerId
 * <p>
 *     The OrganizerId is a unique identifier for the organizer of a sport event.
 * </p>
 * @param organizerId
 * @author  U202212721 Mathias Jave Diaz
 * @version 1.0
 */
@Embeddable
public record OrganizerId(Long organizerId) {

    public OrganizerId {
        if (organizerId < 0) {
            throw new IllegalArgumentException("OrganizerId cannot be less than 0");
        }
    }

    public OrganizerId() {
        this(0L);
    }
}
