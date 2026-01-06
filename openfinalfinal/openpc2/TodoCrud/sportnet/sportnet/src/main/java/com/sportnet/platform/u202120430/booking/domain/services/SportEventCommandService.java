package com.sportnet.platform.u202120430.booking.domain.services;

import com.sportnet.platform.u202120430.booking.domain.model.aggregates.SportEvent;
import com.sportnet.platform.u202120430.booking.domain.model.commands.CreateSportEventCommand;
import com.sportnet.platform.u202120430.booking.domain.model.commands.DeleteSportEventCommand;
import com.sportnet.platform.u202120430.booking.domain.model.commands.UpdateSportEventCommand;

import java.util.Optional;

public interface SportEventCommandService {
    Long handle(CreateSportEventCommand command);
    Optional<SportEvent> handle(UpdateSportEventCommand command);
    Optional<SportEvent> handle(DeleteSportEventCommand command);
}
