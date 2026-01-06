package com.sportnet.platform.u202120430.booking.interfaces.rest.transform;

import com.sportnet.platform.u202120430.booking.domain.model.commands.CreateSportEventCommand;
import com.sportnet.platform.u202120430.booking.interfaces.rest.resources.CreateSportEventResource;

public class CreateSportEventCommandFromResourceAssembler {
    public static CreateSportEventCommand toCommandFromResource(CreateSportEventResource resource){
        return new CreateSportEventCommand(
                resource.eventName(),
                resource.sportType(),
                resource.location(),
                resource.capacity(),
                resource.organizerId()
        );
    }
}
