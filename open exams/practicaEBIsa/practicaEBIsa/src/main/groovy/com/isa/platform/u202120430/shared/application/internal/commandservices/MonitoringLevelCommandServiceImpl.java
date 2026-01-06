package com.isa.platform.u202120430.shared.application.internal.commandservices;

import com.isa.platform.u202120430.shared.domain.model.commands.SeedMonitoringLevelCommand;
import com.isa.platform.u202120430.shared.domain.model.entities.MonitoringLevel;
import com.isa.platform.u202120430.shared.domain.model.valueobjects.MonitoringLevelName;
import com.isa.platform.u202120430.shared.domain.services.MonitoringLevelCommandService;
import com.isa.platform.u202120430.shared.infrastructure.persistence.jpa.repositories.MonitoringLevelRepository;
import org.springframework.stereotype.Service;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */

@Service
public class MonitoringLevelCommandServiceImpl implements MonitoringLevelCommandService {
    private final MonitoringLevelRepository monitoringLevelRepository;

    public MonitoringLevelCommandServiceImpl(MonitoringLevelRepository monitoringLevelRepository) {
        this.monitoringLevelRepository = monitoringLevelRepository;
    }

    @Override
    public Long handle(SeedMonitoringLevelCommand command) {
        MonitoringLevelName[] monitoringLevelNames = MonitoringLevelName.values();
        Long lastId = null;

        for (MonitoringLevelName monitoringLevelName : monitoringLevelNames) {
            if (!monitoringLevelRepository.existsByLevel(monitoringLevelName)) {
                var monitoringLevel = new MonitoringLevel(monitoringLevelName);
                monitoringLevelRepository.save(monitoringLevel);
                lastId = monitoringLevel.getId();
            }
        }

        return lastId;
    }
}
