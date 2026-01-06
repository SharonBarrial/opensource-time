package com.spotify.platform.u202114900.inventories.application.internal.eventhandlers;

import com.spotify.platform.u202114900.inventories.domain.models.command.SeendRythmTypeCommands;
import com.spotify.platform.u202114900.inventories.domain.services.RythmTypeCommandServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ApplicationReadyEventHandler {
    private final RythmTypeCommandServices rythmTypeCommandServices;
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationReadyEventHandler.class);

    public ApplicationReadyEventHandler(RythmTypeCommandServices rythmTypeCommandServices) {
        this.rythmTypeCommandServices = rythmTypeCommandServices;
    }

    @EventListener
    public void on(ApplicationReadyEvent event) {
        var applicationName = event.getApplicationContext().getApplicationName();
        LOGGER.info("Application {} is ready, starting to verify if group types seeding is needed.", applicationName);
        var seedCommand = new SeendRythmTypeCommands();
        rythmTypeCommandServices.handle(seedCommand);
        LOGGER.info("Sensors types seeding is done.");
    }

}
