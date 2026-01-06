package com.isa.platform.u202120430.shared.domain.services;

import com.isa.platform.u202120430.shared.domain.model.commands.SeedMonitoringLevelCommand;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */
public interface MonitoringLevelCommandService {
    Long handle(SeedMonitoringLevelCommand command);
}
