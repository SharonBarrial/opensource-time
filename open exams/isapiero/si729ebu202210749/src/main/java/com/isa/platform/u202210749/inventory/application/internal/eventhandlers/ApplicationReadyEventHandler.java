package com.isa.platform.u202210749.inventory.application.internal.eventhandlers;

import com.isa.platform.u202210749.inventory.domain.model.commands.PopulateMonitoringLevelsCommand;
import com.isa.platform.u202210749.inventory.domain.services.MonitoringLevelCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class ApplicationReadyEventHandler {
    private final MonitoringLevelCommandService monitoringLevelCommandService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationReadyEventHandler.class);

    public ApplicationReadyEventHandler(MonitoringLevelCommandService monitoringLevelCommandService) {
        this.monitoringLevelCommandService = monitoringLevelCommandService;
    }

    @EventListener
    public void on(ApplicationReadyEvent event) {
        var applicationName = event.getApplicationContext().getId();
        LOGGER.info("Starting to verify if the table monitoring levels population is needed for {} at {}", applicationName, currentTimestamp());
        var populateMonitoringLevelsCommand = new PopulateMonitoringLevelsCommand();
        monitoringLevelCommandService.handle(populateMonitoringLevelsCommand);
        LOGGER.info("Table monitoring levels population verification finished for {} at {}", applicationName, currentTimestamp());
    }

    private Timestamp currentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}
