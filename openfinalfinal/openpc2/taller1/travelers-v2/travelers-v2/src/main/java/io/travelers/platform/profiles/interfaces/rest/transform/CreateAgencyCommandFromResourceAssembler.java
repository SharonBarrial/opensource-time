package io.travelers.platform.profiles.interfaces.rest.transform;

import io.travelers.platform.profiles.domain.model.commands.CreateAgencyCommand;
import io.travelers.platform.profiles.interfaces.rest.resources.CreateAgencyResource;

public class CreateAgencyCommandFromResourceAssembler {
    public static CreateAgencyCommand toCommandFromResource(CreateAgencyResource resource){
        return new CreateAgencyCommand(
                resource.businessId(),
                resource.name(),
                resource.street(),
                resource.number(),
                resource.city(),
                resource.postalCode(),
                resource.country(),
                resource.latitude(),
                resource.longitude());
    }
}
