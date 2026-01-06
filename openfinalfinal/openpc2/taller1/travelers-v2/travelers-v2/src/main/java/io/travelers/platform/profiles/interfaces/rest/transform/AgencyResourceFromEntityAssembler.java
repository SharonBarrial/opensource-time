package io.travelers.platform.profiles.interfaces.rest.transform;

import io.travelers.platform.profiles.domain.model.aggregates.Agency;
import io.travelers.platform.profiles.interfaces.rest.resources.AgencyResource;

public class AgencyResourceFromEntityAssembler {
    public static AgencyResource toResourceFromEntity(Agency entity){
        return new AgencyResource(
                entity.getId(),
                entity.getBusinessId(),
                entity.getName(),
                entity.getStreetAddress(),
                entity.getGeolocation()
        );
    }
}
