package com.leedarson.platform.u202120430.devices.application.internal.eventhandlers;

import com.leedarson.platform.u202120430.devices.domain.model.commands.SeedSensorTypeCommand;
import com.leedarson.platform.u202120430.devices.domain.services.SensorTypeCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * Event handler for application ready events to seed sensor types.
 * Author: Nadia Alessandra Lucas Coronel
 * Version: 1.0
 */
@Component
public class ApplicationReadyEventHandler {
    private final SensorTypeCommandService sensorTypeCommandService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationReadyEventHandler.class);

    public ApplicationReadyEventHandler(SensorTypeCommandService sensorTypeCommandService) {
        this.sensorTypeCommandService = sensorTypeCommandService;
    }

    @EventListener
    public void on(ApplicationReadyEvent event) {
        var applicationName = event.getApplicationContext().getId();
        LOGGER.info("Starting to verify if sensor types seeding is needed for {} at {}", applicationName, currentTimestamp());
        var seedRolesCommand = new SeedSensorTypeCommand();
        sensorTypeCommandService.handle(seedRolesCommand);
        LOGGER.info("Sensor types seeding verification finished for {} at {}", applicationName, currentTimestamp());
    }

    private Timestamp currentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}
