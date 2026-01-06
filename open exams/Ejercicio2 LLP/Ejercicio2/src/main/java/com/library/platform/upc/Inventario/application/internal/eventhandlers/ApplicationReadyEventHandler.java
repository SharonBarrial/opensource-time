package com.library.platform.upc.Inventario.application.internal.eventhandlers;

import com.library.platform.upc.Inventario.domain.model.commands.SeedGenresCommand;
import com.library.platform.upc.Inventario.domain.services.GenreCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ApplicationReadyEventHandler {

    private final GenreCommandService genreCommandService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationReadyEventHandler.class);

    public ApplicationReadyEventHandler(GenreCommandService genreCommandService) {
        this.genreCommandService = genreCommandService;
    }

    /**
     * This method is called when the application is ready.
     * It will check if it's necessary to seed the genres.
     *
     * @param event The event that indicates that the application is ready.
     */
    @EventListener
    public void on(ApplicationReadyEvent event) {
        var applicationName = event.getApplicationContext().getApplicationName();
        LOGGER.info("Application {} is ready, starting to verify if genres seeding is needed.", applicationName);
        var seedCommand = new SeedGenresCommand();
        genreCommandService.handle(seedCommand);
        LOGGER.info("Genres seeding is done.");
    }
}