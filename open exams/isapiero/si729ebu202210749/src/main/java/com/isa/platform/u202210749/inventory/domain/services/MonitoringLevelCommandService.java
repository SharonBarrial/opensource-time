package com.isa.platform.u202210749.inventory.domain.services;

import com.isa.platform.u202210749.inventory.domain.model.commands.PopulateMonitoringLevelsCommand;

public interface MonitoringLevelCommandService {
    void handle(PopulateMonitoringLevelsCommand populateMonitoringLevelsCommand);
}
