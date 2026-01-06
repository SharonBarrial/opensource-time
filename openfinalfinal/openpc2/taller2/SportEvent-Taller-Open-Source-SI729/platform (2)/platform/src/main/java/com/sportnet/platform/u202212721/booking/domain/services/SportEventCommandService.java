package com.sportnet.platform.u202212721.booking.domain.services;

import com.sportnet.platform.u202212721.booking.domain.model.aggregates.SportEvent;
import com.sportnet.platform.u202212721.booking.domain.model.commands.CreateSportEventCommand;

import java.util.Optional;

/**
 * SportEventCommandService
 * <p>
 *     This interface represents the SportEventCommandService. It contains the method to handle the creation of a sport event.
 *     Defines the contract for the service that handles the creation of a sport event.
 * </p>
 * @author  U202212721 Mathias Jave Diaz
 * @version 1.0
 */
public interface SportEventCommandService {

    Optional<SportEvent> handle (CreateSportEventCommand command);
}
