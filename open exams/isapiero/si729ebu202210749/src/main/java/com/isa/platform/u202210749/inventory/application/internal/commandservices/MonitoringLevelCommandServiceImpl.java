package com.isa.platform.u202210749.inventory.application.internal.commandservices;

import com.isa.platform.u202210749.inventory.domain.model.entities.MonitoringLevel;
import com.isa.platform.u202210749.inventory.domain.model.valueobjects.MonitoringLevels;
import com.isa.platform.u202210749.inventory.domain.services.MonitoringLevelCommandService;
import com.isa.platform.u202210749.inventory.infrastructure.persistence.jpa.repositories.MonitoringLevelRepository;
import com.isa.platform.u202210749.inventory.domain.model.commands.PopulateMonitoringLevelsCommand;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MonitoringLevelCommandServiceImpl implements MonitoringLevelCommandService {
    private final MonitoringLevelRepository monitoringLevelRepository;

    public MonitoringLevelCommandServiceImpl(MonitoringLevelRepository monitoringLevelRepository) {
        this.monitoringLevelRepository = monitoringLevelRepository;
    }

    @Override
    public void handle(PopulateMonitoringLevelsCommand populateMonitoringLevelsCommand) {
        Arrays.stream(MonitoringLevels.values()).forEach(genreType -> {
            if(!monitoringLevelRepository.existsByName(genreType))
                monitoringLevelRepository.save(new MonitoringLevel(genreType));
        });
    }
}
