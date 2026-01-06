package com.spotify.platform.u202114900.inventories.application.internal.commandservices;

import com.spotify.platform.u202114900.inventories.domain.models.command.SeendRythmTypeCommands;
import com.spotify.platform.u202114900.inventories.domain.models.entities.RythmType;
import com.spotify.platform.u202114900.inventories.domain.models.valueobjects.RythmTypes;
import com.spotify.platform.u202114900.inventories.domain.services.RythmTypeCommandServices;
import com.spotify.platform.u202114900.inventories.infrastructure.persistence.jpa.repositories.RythmTypeRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RythmTypeCommandServiceImpl implements RythmTypeCommandServices {

    private final RythmTypeRepository rythmTypeRepository;

    public RythmTypeCommandServiceImpl(RythmTypeRepository rythmTypeRepository) {
        this.rythmTypeRepository = rythmTypeRepository;
    }

    /**
     * @summary Iterate over RythmTypes and check if they exist in the database, if not, save them
     * @param command SeedGroupTypesCommand
     * @author Sharon Barrial Marin
     */

    @Override
    public void handle(SeendRythmTypeCommands command) {
        Arrays.stream(RythmTypes.values()).forEach(name -> {
            if (!rythmTypeRepository.existsByName(name)) {
                rythmTypeRepository.save(new RythmType(name));
            }
        });
    }
}
