package com.isa.platform.u202120430.monitoring.domain.services;

import com.isa.platform.u202120430.monitoring.domain.model.commands.CreateSnapshotCommand;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */
public interface SnapshotCommandService {
    Long handle(CreateSnapshotCommand command);
}
