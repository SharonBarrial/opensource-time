package com.sportnet.platform.u202120430.booking.application.internal.queryservices;

import com.sportnet.platform.u202120430.booking.domain.model.aggregates.SportEvent;
import com.sportnet.platform.u202120430.booking.domain.model.queries.GetAllSportEventsQuery;
import com.sportnet.platform.u202120430.booking.domain.model.queries.GetSportEventByIdQuery;
import com.sportnet.platform.u202120430.booking.domain.services.SportEventQueryService;
import com.sportnet.platform.u202120430.booking.infrastructure.persitence.jpa.repositories.SportEventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SportEventQueryServiceImpl implements SportEventQueryService {
    private final SportEventRepository sportEventRepository;

    public SportEventQueryServiceImpl(SportEventRepository sportEventRepository) {
        this.sportEventRepository = sportEventRepository;
    }

    @Override
    public List<SportEvent> handle(GetAllSportEventsQuery query) {
        return sportEventRepository.findAll();
    }

    @Override
    public Optional<SportEvent> handle(GetSportEventByIdQuery query) {
        return sportEventRepository.findById(query.sportEventId());
    }
}
