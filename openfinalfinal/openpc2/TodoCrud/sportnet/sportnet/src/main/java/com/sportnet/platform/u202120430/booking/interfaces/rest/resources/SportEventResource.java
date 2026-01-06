package com.sportnet.platform.u202120430.booking.interfaces.rest.resources;

public record SportEventResource(
        Long id,
        String eventName,
        String sportType,
        String location,
        int capacity,
        long organizerId
) {
}
