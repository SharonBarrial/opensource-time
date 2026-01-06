package com.isa.platform.u202120430.monitoring.interfaces.rest.transform;

import com.isa.platform.u202120430.monitoring.domain.model.aggregates.Snapshot;
import com.isa.platform.u202120430.monitoring.interfaces.rest.resources.SnapshotResource;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */
public class SnapshotResourceFromEntityAssembler {
    public static SnapshotResource toResourceFromEntity(Snapshot entity) {
        return new SnapshotResource(
                entity.getId(),
                entity.getProduct().getId(),
                entity.getProductSerialNumber(),
                entity.getTemperature(),
                entity.getEnergy(),
                entity.getLeakage()
        );
    }
}
