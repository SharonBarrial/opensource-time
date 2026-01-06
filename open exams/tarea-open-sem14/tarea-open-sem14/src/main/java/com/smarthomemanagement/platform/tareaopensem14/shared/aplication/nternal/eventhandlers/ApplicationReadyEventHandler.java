package com.smarthomemanagement.platform.tareaopensem14.shared.aplication.nternal.eventhandlers;

import com.smarthomemanagement.platform.tareaopensem14.shared.domain.model.commands.SeedDeviceTypeCommand;
import com.smarthomemanagement.platform.tareaopensem14.shared.domain.services.DeviceTypeCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * @author Vargas Revollé, Ariana - u20221928
 * @version 1.0
 */

@Component
public class ApplicationReadyEventHandler {
    private final DeviceTypeCommandService deviceTypeCommandService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationReadyEventHandler.class);

    public ApplicationReadyEventHandler(DeviceTypeCommandService deviceTypeCommandService) {
        this.deviceTypeCommandService = deviceTypeCommandService;
    }

    @EventListener
    public void on(ApplicationReadyEvent event) {
        var applicationName = event.getApplicationContext().getId();
        LOGGER.info("Starting to verify if device type seeding is needed for {} at {}", applicationName, currentTimestamp());
        var seedRolesCommand = new SeedDeviceTypeCommand();
        deviceTypeCommandService.handle(seedRolesCommand);
        LOGGER.info("Device type seeding verification finished for {} at {}", applicationName, currentTimestamp());
    }

    private Timestamp currentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}
