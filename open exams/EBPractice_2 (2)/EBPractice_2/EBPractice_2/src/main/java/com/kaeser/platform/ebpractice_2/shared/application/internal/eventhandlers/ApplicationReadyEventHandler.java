package com.kaeser.platform.ebpractice_2.shared.application.internal.eventhandlers;

import com.kaeser.platform.ebpractice_2.shared.domain.model.commands.SeedEquipmentTypeCommmand;
import com.kaeser.platform.ebpractice_2.shared.domain.services.EquipmentTypeCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * Event handler for the application ready event.
 *
 * @version 1.0
 */
@Component
public class ApplicationReadyEventHandler {
    private final EquipmentTypeCommandService deviceTypeCommandService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationReadyEventHandler.class);

    public ApplicationReadyEventHandler(EquipmentTypeCommandService equipmentTypeCommandService) {
        this.deviceTypeCommandService = equipmentTypeCommandService;
    }

    @EventListener
    public void on(ApplicationReadyEvent event) {
        var applicationName = event.getApplicationContext().getId();
        LOGGER.info("Starting to verify if equipment type seeding is needed for {} at {}", applicationName, currentTimestamp());
        var seedRolesCommand = new SeedEquipmentTypeCommmand();
        deviceTypeCommandService.handle(seedRolesCommand);
        LOGGER.info("Equipment type seeding verification finished for {} at {}", applicationName, currentTimestamp());
    }

    private Timestamp currentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}
