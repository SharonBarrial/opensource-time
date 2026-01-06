package com.agrimarket.inventories.application.internal.eventhandlers;

import com.agrimarket.inventories.domain.model.commands.SeedCategoryTypeCommand;
import com.agrimarket.inventories.domain.services.CategoryTypeCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class ApplicationReadyEventHandler {
    private final CategoryTypeCommandService categoryTypeCommandService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationReadyEventHandler.class);

    public ApplicationReadyEventHandler(CategoryTypeCommandService categoryTypeCommandService) {
        this.categoryTypeCommandService = categoryTypeCommandService;
    }

    @EventListener
    public void on(ApplicationReadyEvent event) {
        var applicationName = event.getApplicationContext().getId();
        //LOGGER.info("Starting to verify if category types seeding is needed for {} at {}", applicationName, System.currentTimeMillis());
        LOGGER.info("Starting to verify if category types seeding is needed for {} at {}", applicationName, currentTimestamp());
        var seedCategoryTypeCommand = new SeedCategoryTypeCommand();
        categoryTypeCommandService.handle(seedCategoryTypeCommand);
        //LOGGER.info("Category types seeding verification finished for {} at {}.", applicationName, System.currentTimeMillis());
        LOGGER.info("Category types seeding verification finished for {} at {}", applicationName, System.currentTimeMillis());
    }

    //Java.sql.Timestamp is used to get the current timestamp
    private Timestamp currentTimestamp() {return new Timestamp(System.currentTimeMillis());}
}
