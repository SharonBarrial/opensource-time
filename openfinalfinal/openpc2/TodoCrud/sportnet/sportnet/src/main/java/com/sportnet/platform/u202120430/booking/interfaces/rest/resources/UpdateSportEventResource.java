package com.sportnet.platform.u202120430.booking.interfaces.rest.resources;

public record UpdateSportEventResource (
        String eventName,
        String sportType,
        String location,
        int capacity,
        long organizerId
) {
}
