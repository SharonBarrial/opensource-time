package com.isa.platform.u202210749.inventory.interfaces.rest.transform;

import com.isa.platform.u202210749.inventory.domain.model.commands.CreateProductCommand;
import com.isa.platform.u202210749.inventory.interfaces.rest.resources.CreateProductResource;

public class CreateProductCommandFromResourceAssembler {
    public static CreateProductCommand toCommandFromResource(CreateProductResource createProductResource) {
        return new CreateProductCommand(
                createProductResource.brand(),
                createProductResource.model(),
                createProductResource.serialNumber(),
                createProductResource.monitoringLevelId());
    }
}
