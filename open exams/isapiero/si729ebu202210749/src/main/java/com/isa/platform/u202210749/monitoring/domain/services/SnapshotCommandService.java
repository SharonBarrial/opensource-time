package com.isa.platform.u202210749.monitoring.domain.services;

import com.isa.platform.u202210749.monitoring.domain.model.commands.CreateSnapshotCommand;

public interface SnapshotCommandService {
    Long handle(CreateSnapshotCommand command);
}
