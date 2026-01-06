package com.library.platform.upc.inventory.application.internal.eventhandlers;

import com.library.platform.upc.inventory.domain.model.commands.PopulateGenresCommand;
import com.library.platform.upc.inventory.domain.services.GenreCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service("inventoryApplicationReadyEventHandler")
public class ApplicationReadyEventHandler {
    private final GenreCommandService genreCommandService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationReadyEventHandler.class);

    public ApplicationReadyEventHandler(GenreCommandService genreCommandService) {
        this.genreCommandService = genreCommandService;
    }

    @EventListener
    public void on(ApplicationReadyEvent event) {
        var applicationName = event.getApplicationContext().getId();
        LOGGER.info("Starting to verify if the table genres population is needed for {} at {}", applicationName, currentTimestamp());
        var populateGenresCommand = new PopulateGenresCommand();
        genreCommandService.handle(populateGenresCommand);
        LOGGER.info("Table genres population verification finished for {} at {}", applicationName, currentTimestamp());
    }

    private Timestamp currentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}
