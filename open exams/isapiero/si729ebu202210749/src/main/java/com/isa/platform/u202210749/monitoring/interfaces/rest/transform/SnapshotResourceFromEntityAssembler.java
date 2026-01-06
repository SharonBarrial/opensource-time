package com.isa.platform.u202210749.monitoring.interfaces.rest.transform;

import com.isa.platform.u202210749.monitoring.domain.model.aggregates.Snapshot;
import com.isa.platform.u202210749.monitoring.interfaces.rest.resources.CreateSnapshotResource;
import com.isa.platform.u202210749.monitoring.interfaces.rest.resources.SnapshotResource;

public class SnapshotResourceFromEntityAssembler {
    public static SnapshotResource toResourceFromEntity(Snapshot entity) {
        return new SnapshotResource(
                entity.getId(),
                entity.getSnapshotId(),
                entity.getProductSerialNumber(),
                entity.getTemperature(),
                entity.getEnergy(),
                entity.getLeakage()
        );
    }
}
