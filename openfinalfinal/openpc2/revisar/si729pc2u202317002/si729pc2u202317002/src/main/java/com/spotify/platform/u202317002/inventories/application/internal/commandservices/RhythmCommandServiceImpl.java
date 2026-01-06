package com.spotify.platform.u202317002.inventories.application.internal.commandservices;

import com.spotify.platform.u202317002.inventories.domain.models.commands.SeedRhythmsCommand;
import com.spotify.platform.u202317002.inventories.domain.models.entities.Rhythm;
import com.spotify.platform.u202317002.inventories.domain.models.valueobjets.Rhythms;
import com.spotify.platform.u202317002.inventories.domain.services.RhythmCommandService;
import com.spotify.platform.u202317002.inventories.infrastructure.persistence.jpa.repositories.RhythmRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@AllArgsConstructor
public class RhythmCommandServiceImpl implements RhythmCommandService {

    private final RhythmRepository rhythmRepository;

    /**
     * @summary Iterate over Rhythms and check if they exist in the database, if not, save them
     * @param command SeedRhythmsCommand
     */
    @Override
    public void handle(SeedRhythmsCommand command) {
        Arrays.stream(Rhythms.values()).forEach(rhythm -> {
            if (!rhythmRepository.existsByName(rhythm)) {
                rhythmRepository.save(new Rhythm(rhythm));
            }
        });
    }
}