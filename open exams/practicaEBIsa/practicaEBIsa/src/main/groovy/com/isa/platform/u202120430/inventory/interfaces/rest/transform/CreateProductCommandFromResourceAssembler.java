package com.isa.platform.u202120430.inventory.interfaces.rest.transform;

import com.isa.platform.u202120430.inventory.domain.model.commands.CreateProductCommand;
import com.isa.platform.u202120430.inventory.interfaces.rest.resources.CreateProductResource;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */
public class CreateProductCommandFromResourceAssembler {
    public static CreateProductCommand toCommandFromResource(CreateProductResource resource) {
        return new CreateProductCommand(
                resource.brand(),
                resource.model(),
                resource.serialNumber(),
                resource.monitoringLevel());
    }
}
