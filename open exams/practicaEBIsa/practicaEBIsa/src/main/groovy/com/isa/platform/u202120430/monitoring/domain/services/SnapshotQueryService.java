package com.isa.platform.u202120430.monitoring.domain.services;

import com.isa.platform.u202120430.monitoring.domain.model.aggregates.Snapshot;
import com.isa.platform.u202120430.monitoring.domain.model.queries.GetSnapshotByIdQuery;
import com.isa.platform.u202120430.monitoring.domain.model.queries.GetSnapshotsByProductIdQuery;

import java.util.List;
import java.util.Optional;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */
public interface SnapshotQueryService {
    Optional<Snapshot> handle(GetSnapshotByIdQuery query);
    List<Snapshot> handle(GetSnapshotsByProductIdQuery query);
}
