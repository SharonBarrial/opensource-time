package com.sportnet.platform.u202212721.booking.interfaces.rest.transform;

import com.sportnet.platform.u202212721.booking.domain.model.aggregates.SportEvent;
import com.sportnet.platform.u202212721.booking.interfaces.rest.resources.SportEventResource;

/**
 * This class is responsible for converting a SportEvent entity to a SportEventResource.
 * <p>
 *     The SportEventResource is a representation of the SportEvent entity that is used to send data to the client.
 * </p>
 * @author U202212721 Mathias Jave Diaz
 * @version 1.0
 */
public class SportEventResourceFromEntityAssembler {

    public static SportEventResource toResourceFromEntity(SportEvent sportEvent){
        return new SportEventResource(sportEvent.getId(), sportEvent.getEventName()
                , sportEvent.getOrganizerId().organizerId(), sportEvent.getSportType(), sportEvent.getLocation(), sportEvent.getCapacity());
    }
}
