package com.sportnet.platform.u202120430.booking.interfaces.rest.resources;

import jakarta.validation.constraints.NotNull;

public record CreateSportEventResource (
        @NotNull String eventName,
        @NotNull String sportType,
        @NotNull String location,
        @NotNull int capacity,
        @NotNull long organizerId
) {
}
