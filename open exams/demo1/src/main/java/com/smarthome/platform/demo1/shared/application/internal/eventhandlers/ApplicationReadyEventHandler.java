package com.smarthome.platform.demo1.shared.application.internal.eventhandlers;

import com.smarthome.platform.demo1.shared.application.internal.commandservices.DeviceTypeCommandServiceImpl;
import com.smarthome.platform.demo1.shared.domain.model.commands.SeedDeviceTypeCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;


/**
 * ApplicationReadyEventHandler
 * <p>
 *     This class is used to handle the application ready event.
 *     This class is used to seed the device types in the database when the application is ready.
 *     The device types are seeded in the database when the application is ready.
 * </p>
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */

@Service("deviceTypeApplicationReadyEventHandler")
public class ApplicationReadyEventHandler {

    /**
     * The device type command service.
     */

    private final DeviceTypeCommandServiceImpl deviceTypeCommandServiceImpl;
    private static final Logger LOGGER = LoggerFactory.getLogger(com.smarthome.platform.demo1.iam.application.internal.eventhandlers.ApplicationReadyEventHandler.class);

    public ApplicationReadyEventHandler(DeviceTypeCommandServiceImpl deviceTypeCommandService) {
        this.deviceTypeCommandServiceImpl = deviceTypeCommandService;
    }

    /**
     * Handle the application ready event.
     * <p>
     *     This method is used to handle the application ready event.
     *     The device types are seeded in the database when the application is ready.
     * </p>
     * @param event The application ready event.
     */

    @EventListener
    public void on(ApplicationReadyEvent event) {
        var applicationName = event.getApplicationContext().getId();
        LOGGER.info("Starting to verify if roles seeding is needed for {} at {}", applicationName, currentTimestamp());
        var seedDeviceTypeCommand = new SeedDeviceTypeCommand();
        deviceTypeCommandServiceImpl.handle(seedDeviceTypeCommand);
        LOGGER.info("Roles seeding verification finished for {} at {}", applicationName, currentTimestamp());
    }

    /**
     * Get the current timestamp.
     * <p>
     *     This method is used to get the current timestamp.
     * </p>
     * @return The current timestamp.
     */

    private Timestamp currentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }


}
