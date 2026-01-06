package com.isa.platform.u20221b127.monitoring.interfaces.rest.transform;

import com.isa.platform.u20221b127.monitoring.domain.model.aggregates.Snapshot;
import com.isa.platform.u20221b127.monitoring.interfaces.rest.resources.SnapshotResource;

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
