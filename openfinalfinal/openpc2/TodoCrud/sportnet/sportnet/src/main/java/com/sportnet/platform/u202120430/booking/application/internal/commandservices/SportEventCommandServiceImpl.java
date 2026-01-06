package com.sportnet.platform.u202120430.booking.application.internal.commandservices;

import com.sportnet.platform.u202120430.booking.domain.model.aggregates.SportEvent;
import com.sportnet.platform.u202120430.booking.domain.model.commands.CreateSportEventCommand;
import com.sportnet.platform.u202120430.booking.domain.model.commands.DeleteSportEventCommand;
import com.sportnet.platform.u202120430.booking.domain.model.commands.UpdateSportEventCommand;
import com.sportnet.platform.u202120430.booking.domain.model.valueobjects.*;
import com.sportnet.platform.u202120430.booking.domain.services.SportEventCommandService;
import com.sportnet.platform.u202120430.booking.infrastructure.persitence.jpa.repositories.SportEventRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SportEventCommandServiceImpl implements SportEventCommandService {
    private final SportEventRepository sportEventRepository;

    public SportEventCommandServiceImpl(SportEventRepository sportEventRepository) {
        this.sportEventRepository = sportEventRepository;
    }

    /**
     Este es el que piden en la pc
     */
    @Override
    public Long handle(CreateSportEventCommand command) {
        EventName eventName = new EventName(command.eventName());
        SportType sportType = new SportType(command.sportType());
        Location location = new Location(command.location());
        OrganizerId organizerId = new OrganizerId(command.organizerId());

        boolean eventExists = sportEventRepository.existsByEventNameAndSportTypeAndLocation(
                eventName, sportType, location);
        if (eventExists) {
            throw new IllegalArgumentException("An event with the same name, sport type, and location already exists.");
        }

        boolean organizerEventExists = sportEventRepository.existsByOrganizerId(organizerId);
        if (organizerEventExists) {
            throw new IllegalArgumentException("An event with the same organizer ID already exists for the same day.");
        }

        if (command.capacity() == null || command.capacity() <= 0) {
            throw new IllegalArgumentException("Capacity must be a positive value.");
        }


        var sportEvent = new SportEvent(command);
        try {
            sportEventRepository.save(sportEvent);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving sport event: " + e.getMessage());
        }return sportEvent.getId();
    }

    @Override
    public Optional<SportEvent> handle(UpdateSportEventCommand command) {
        return sportEventRepository.findById(command.sportEventId()).map(sportEvent -> {
            sportEvent.setEventName(new EventName(command.eventName()));
            sportEvent.setSportType(new SportType(command.sportType()));
            sportEvent.setLocation(new Location(command.location()));
            sportEvent.setCapacity(new Capacity(command.capacity()));
            sportEvent.setOrganizerId(new OrganizerId(command.organizerId()));
            return sportEvent;
        });
    }

    @Override
    public Optional<SportEvent> handle(DeleteSportEventCommand command) {
        if (!sportEventRepository.existsById(command.sportEventId())) {
            throw new IllegalArgumentException("Sport event does not exist");
        }
        var sportEvent = sportEventRepository.findById(command.sportEventId());
        sportEvent.ifPresent(sportEventRepository::delete);
        return sportEvent;
    }
}
