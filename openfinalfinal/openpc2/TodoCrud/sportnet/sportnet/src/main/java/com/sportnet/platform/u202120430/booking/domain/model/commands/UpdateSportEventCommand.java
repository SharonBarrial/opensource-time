package com.sportnet.platform.u202120430.booking.domain.model.commands;

public record UpdateSportEventCommand (
        Long sportEventId,
        String eventName,
        String sportType,
        String location,
        Integer capacity,
        Long organizerId
){}
