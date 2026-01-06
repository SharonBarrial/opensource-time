package com.sportnet.platform.u202212721.booking.application.internal.eventhandlers;

import com.sportnet.platform.u202212721.booking.domain.services.SportEventCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ApplicationStartEventHandler {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationStartEventHandler.class);

    private final SportEventCommandService sportEventCommandService;

    public ApplicationStartEventHandler(SportEventCommandService sportEventCommandService) {
        this.sportEventCommandService = sportEventCommandService;
    }

    @EventListener
    public void on(ApplicationReadyEvent event){
         var applicationName = event.getApplicationContext().getApplicationName();
         logger.info("Application started you can send me your sports events, now you need to go to the swagger ui for acces", applicationName);

    }



}
