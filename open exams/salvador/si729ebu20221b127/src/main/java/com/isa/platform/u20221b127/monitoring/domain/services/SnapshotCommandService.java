package com.isa.platform.u20221b127.monitoring.domain.services;

import com.isa.platform.u20221b127.monitoring.domain.model.aggregates.Snapshot;
import com.isa.platform.u20221b127.monitoring.domain.model.commands.CreateSnapshotCommand;

import java.util.Optional;

public interface SnapshotCommandService {
    Optional<Snapshot> handle(CreateSnapshotCommand command, Long productId);
}
