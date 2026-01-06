package com.sportnet.platform.u202120430.booking.domain.model.commands;

public record CreateSportEventCommand (
        String eventName,
        String sportType,
        String location,
        Integer capacity,
        Long organizerId
){}
