package com.isa.platform.u202210749.monitoring.interfaces.rest.transform;

import com.isa.platform.u202210749.monitoring.domain.model.commands.CreateSnapshotCommand;
import com.isa.platform.u202210749.monitoring.interfaces.rest.resources.CreateSnapshotResource;

public class CreateSnapshotCommandFromResourceAssembler {
    public static CreateSnapshotCommand toCommandFromResource(CreateSnapshotResource resource) {
        return new CreateSnapshotCommand(
                resource.snapshotId(),
                resource.productSerialNumber(),
                resource.temperature(),
                resource.energy(),
                resource.leakage()
        );
    }
}
