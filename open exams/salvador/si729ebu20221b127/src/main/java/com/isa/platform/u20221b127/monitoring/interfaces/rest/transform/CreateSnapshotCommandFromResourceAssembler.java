package com.isa.platform.u20221b127.monitoring.interfaces.rest.transform;

import com.isa.platform.u20221b127.monitoring.domain.model.commands.CreateSnapshotCommand;
import com.isa.platform.u20221b127.monitoring.interfaces.rest.resources.CreateSnapshotResource;

public class CreateSnapshotCommandFromResourceAssembler {
    public static CreateSnapshotCommand toCommandFromResource(CreateSnapshotResource resource) {
        return new CreateSnapshotCommand(
                resource.snapshotId(),
                resource.temperature(),
                resource.energy(),
                resource.leakage()
        );
    }
}
