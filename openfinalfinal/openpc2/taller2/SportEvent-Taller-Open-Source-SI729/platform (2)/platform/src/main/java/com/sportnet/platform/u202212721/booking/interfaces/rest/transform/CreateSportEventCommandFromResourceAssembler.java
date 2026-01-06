package com.sportnet.platform.u202212721.booking.interfaces.rest.transform;

import com.sportnet.platform.u202212721.booking.domain.model.commands.CreateSportEventCommand;
import com.sportnet.platform.u202212721.booking.interfaces.rest.resources.CreateSportEventResource;

/**
 * This class is responsible for converting the CreateSportEventResource to a CreateSportEventCommand
 * <p>
 *     This class is used to convert the CreateSportEventResource to a CreateSportEventCommand
 * </p>
 * @author  U202212721 Mathias Jave Diaz
 * @version 1.0
 */
public class CreateSportEventCommandFromResourceAssembler {
    public static CreateSportEventCommand toCommandFromResource (CreateSportEventResource resource){
         return new CreateSportEventCommand(resource.eventName(), resource.organizerId(),resource.sportType(), resource.location(), resource.capacity());
    }
}
