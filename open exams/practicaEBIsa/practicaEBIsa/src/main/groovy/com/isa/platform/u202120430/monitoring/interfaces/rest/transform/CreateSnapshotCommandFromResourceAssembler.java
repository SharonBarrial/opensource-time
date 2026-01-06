package com.isa.platform.u202120430.monitoring.interfaces.rest.transform;

import com.isa.platform.u202120430.monitoring.domain.model.commands.CreateSnapshotCommand;
import com.isa.platform.u202120430.monitoring.interfaces.rest.resources.CreateSnapshotResource;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */
public class CreateSnapshotCommandFromResourceAssembler {
    public static CreateSnapshotCommand toCommandFromResource(CreateSnapshotResource resource) {
        return new CreateSnapshotCommand(
                resource.productId(),
                resource.productSerialNumber(),
                resource.temperature(),
                resource.energy(),
                resource.leakage());
    }
}
