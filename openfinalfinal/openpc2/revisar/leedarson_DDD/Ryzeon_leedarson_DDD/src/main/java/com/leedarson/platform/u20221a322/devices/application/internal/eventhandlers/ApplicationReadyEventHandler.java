package com.leedarson.platform.u20221a322.devices.application.internal.eventhandlers;

import com.leedarson.platform.u20221a322.devices.domain.model.commands.SeedSensorTypesCommand;
import com.leedarson.platform.u20221a322.devices.domain.services.SensorTypeCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: leedarson
 * Date: 12/06/24 @ 01:05
 */
@Service
public class ApplicationReadyEventHandler {

    private final SensorTypeCommandService sensorTypeCommandService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationReadyEventHandler.class);

    public ApplicationReadyEventHandler(SensorTypeCommandService sensorTypeCommandService) {
        this.sensorTypeCommandService = sensorTypeCommandService;
    }

    /**
     * This method is called when the application is ready.
     * It will verify if the sensors types seeding is needed.
     *
     * @param event The event that indicates that the application is ready.
     * @author Alex Avila Asto
     */
    @EventListener
    public void on(ApplicationReadyEvent event) {
        var applicationName = event.getApplicationContext().getApplicationName();
        LOGGER.info("Application {} is ready, starting to verify if sensors types seeding is needed.", applicationName);
        var seedCommand = new SeedSensorTypesCommand();
        sensorTypeCommandService.handle(seedCommand);
        LOGGER.info("Sensors types seeding is done.");
    }
}
