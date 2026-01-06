package com.sportnet.platform.u202212721.booking.application.internal.commandservices;

import com.sportnet.platform.u202212721.booking.domain.model.aggregates.SportEvent;
import com.sportnet.platform.u202212721.booking.domain.model.commands.CreateSportEventCommand;
import com.sportnet.platform.u202212721.booking.domain.services.SportEventCommandService;
import com.sportnet.platform.u202212721.booking.infrastructure.persitence.jpa.repositories.SportEventRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * SportEventCommandServiceImpl
 * <p>
 *     This class implements the SportEventCommandService interface. It contains the method to handle the creation of a sport event.
 * </p>
 * @author  U202212721 Mathias Jave Diaz
 * @version 1.0
 */
@Service
public class SportEventCommandServiceImpl implements SportEventCommandService {

    private final SportEventRepository sportEventRepository;

    public SportEventCommandServiceImpl(SportEventRepository sportEventRepository) {
        this.sportEventRepository = sportEventRepository;
    }

    @Override
    public Optional<SportEvent> handle(CreateSportEventCommand command) {
        try {
            var sportEvent = new SportEvent(command);
            if (sportEventRepository.existsByEventNameAndSportTypeAndLocation(sportEvent.getEventName(), sportEvent.getSportType(), sportEvent.getLocation())){
                throw new IllegalArgumentException("Sport event already exists in this location");
            }
            if (sportEventRepository.existsByOrganizerId(sportEvent.getOrganizerId())){
                throw new IllegalArgumentException("Organizer already has a sport event");
            }
            sportEventRepository.save(sportEvent);
            return Optional.of(sportEvent);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
