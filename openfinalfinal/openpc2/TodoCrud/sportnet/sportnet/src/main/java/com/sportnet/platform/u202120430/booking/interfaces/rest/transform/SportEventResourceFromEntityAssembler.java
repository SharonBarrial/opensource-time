package com.sportnet.platform.u202120430.booking.interfaces.rest.transform;

import com.sportnet.platform.u202120430.booking.domain.model.aggregates.SportEvent;
import com.sportnet.platform.u202120430.booking.interfaces.rest.resources.SportEventResource;

public class SportEventResourceFromEntityAssembler {
    public static SportEventResource toResourceFromEntity(SportEvent entity) {
        return new SportEventResource(
                entity.getId(),
                entity.getEventName(),
                entity.getSportType(),
                entity.getLocation(),
                entity.getCapacity(),
                entity.getOrganizerId());
    }
}
