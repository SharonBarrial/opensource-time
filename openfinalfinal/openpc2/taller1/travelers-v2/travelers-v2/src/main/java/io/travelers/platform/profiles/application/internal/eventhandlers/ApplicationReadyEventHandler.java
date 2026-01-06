package io.travelers.platform.profiles.application.internal.eventhandlers;

import io.travelers.platform.profiles.domain.model.commands.PopulateBusinessTableCommand;
import io.travelers.platform.profiles.domain.model.entities.Business;
import io.travelers.platform.profiles.infrastructure.persistence.jpa.repositories.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplicationReadyEventHandler {

    private static final List<PopulateBusinessTableCommand> INITIAL_BUSINESSES = List.of(
            new PopulateBusinessTableCommand(1L, "Business A"),
            new PopulateBusinessTableCommand(2L, "Business B"),
            new PopulateBusinessTableCommand(3L, "Business C")
    );

    @Autowired
    private BusinessRepository businessRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void populateBusinessTable() {
        for (PopulateBusinessTableCommand command : INITIAL_BUSINESSES) {
            if (!businessRepository.existsByName(command.getName())) {
                Business business = new Business();
                business.setName(command.getName());
                businessRepository.save(business);
            }
        }
    }
}
