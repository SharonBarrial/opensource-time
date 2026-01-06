package com.sportnet.platform.u202120430.booking.domain.services;

import com.sportnet.platform.u202120430.booking.domain.model.aggregates.SportEvent;
import com.sportnet.platform.u202120430.booking.domain.model.queries.GetAllSportEventsQuery;
import com.sportnet.platform.u202120430.booking.domain.model.queries.GetSportEventByIdQuery;

import java.util.List;
import java.util.Optional;


public interface SportEventQueryService {
    List<SportEvent> handle(GetAllSportEventsQuery query);
    Optional<SportEvent> handle(GetSportEventByIdQuery query);
}
