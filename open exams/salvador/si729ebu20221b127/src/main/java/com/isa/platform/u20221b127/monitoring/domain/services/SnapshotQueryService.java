package com.isa.platform.u20221b127.monitoring.domain.services;

import com.isa.platform.u20221b127.monitoring.domain.model.aggregates.Snapshot;
import com.isa.platform.u20221b127.monitoring.domain.model.queries.GetSnapshotsByProductIdQuery;

import java.util.List;

public interface SnapshotQueryService {
    List<Snapshot> handle(GetSnapshotsByProductIdQuery query);
}
