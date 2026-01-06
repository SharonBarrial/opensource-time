package com.sportnet.platform.u202120430.booking.interfaces.rest.transform;

import com.sportnet.platform.u202120430.booking.domain.model.commands.UpdateSportEventCommand;
import com.sportnet.platform.u202120430.booking.interfaces.rest.resources.UpdateSportEventResource;

public class UpdateSportEventCommandFromResourceAssembler {
    public static UpdateSportEventCommand toCommandFromResource(Long sportEventId, UpdateSportEventResource resource) {
        return new UpdateSportEventCommand(
                sportEventId,
                resource.eventName(),
                resource.sportType(),
                resource.location(),
                resource.capacity(),
                resource.organizerId()
        );
    }
}
