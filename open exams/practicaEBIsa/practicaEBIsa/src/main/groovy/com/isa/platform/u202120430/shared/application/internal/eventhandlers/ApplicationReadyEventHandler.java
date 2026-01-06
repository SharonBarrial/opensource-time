package com.isa.platform.u202120430.shared.application.internal.eventhandlers;

import com.isa.platform.u202120430.shared.domain.model.commands.SeedMonitoringLevelCommand;
import com.isa.platform.u202120430.shared.domain.services.MonitoringLevelCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */

@Component
public class ApplicationReadyEventHandler {
    private final MonitoringLevelCommandService monitoringLevelCommandService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationReadyEventHandler.class);

    public ApplicationReadyEventHandler(MonitoringLevelCommandService monitoringLevelCommandService) {
        this.monitoringLevelCommandService = monitoringLevelCommandService;
    }

    @EventListener
    public void on(ApplicationReadyEvent event) {
        var applicationName = event.getApplicationContext().getId();
        LOGGER.info("Starting to verify if monitoring level seeding is needed for {} at {}", applicationName, currentTimestamp());
        var seedMonitoringLevelCommand = new SeedMonitoringLevelCommand();
        monitoringLevelCommandService.handle(seedMonitoringLevelCommand);
        LOGGER.info("Monitoring level seeding verification finished for {} at {}", applicationName, currentTimestamp());
    }

    private Timestamp currentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

}
