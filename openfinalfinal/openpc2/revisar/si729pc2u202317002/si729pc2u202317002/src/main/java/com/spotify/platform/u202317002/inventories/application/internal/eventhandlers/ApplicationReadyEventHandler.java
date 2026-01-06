package com.spotify.platform.u202317002.inventories.application.internal.eventhandlers;

import com.spotify.platform.u202317002.inventories.domain.models.commands.SeedRhythmsCommand;
import com.spotify.platform.u202317002.inventories.domain.services.RhythmCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ApplicationReadyEventHandler {

    private final RhythmCommandService rhythmCommandService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationReadyEventHandler.class);

    public ApplicationReadyEventHandler(RhythmCommandService rhythmCommandService) {
        this.rhythmCommandService = rhythmCommandService;
    }

    /**
     * This method is called when the application is ready.
     * It will verify if the rhythms types seeding is needed.
     *
     * @param event The event that indicates that the application is ready.
     */
    @EventListener
    public void on(ApplicationReadyEvent event) {
        var applicationName = event.getApplicationContext().getApplicationName();
        LOGGER.info("Application {} is ready, starting to verify if rhythms types seeding is needed.", applicationName);
        var seedCommand = new SeedRhythmsCommand();
        rhythmCommandService.handle(seedCommand);
        LOGGER.info("Rhythms seeding is done.");
    }
}