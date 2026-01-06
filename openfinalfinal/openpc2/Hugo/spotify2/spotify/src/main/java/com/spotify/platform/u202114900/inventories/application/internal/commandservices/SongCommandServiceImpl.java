package com.spotify.platform.u202114900.inventories.application.internal.commandservices;

import com.spotify.platform.u202114900.inventories.domain.models.aggregates.Song;
import com.spotify.platform.u202114900.inventories.domain.models.command.CreateSongCommand;
import com.spotify.platform.u202114900.inventories.domain.services.SongCommandServices;
import com.spotify.platform.u202114900.inventories.infrastructure.persistence.jpa.repositories.RythmTypeRepository;
import com.spotify.platform.u202114900.inventories.infrastructure.persistence.jpa.repositories.SongRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongCommandServiceImpl implements SongCommandServices {

    private final SongRepository songRepository;
    private final RythmTypeRepository rythmTypeRepository;

    public SongCommandServiceImpl(SongRepository songRepository, RythmTypeRepository rythmTypeRepository) {
        this.songRepository = songRepository;
        this.rythmTypeRepository = rythmTypeRepository;
    }

    /**
     * @param command CreateSongCommand
     * @return Optional<Sensor>
     * @throws RuntimeException if sensor with name, sensorTypeId and manufacturer already exists
     * @throws RuntimeException if SensorType with id does not exist
     * @summary Checks if a sensor with parameters Also verifies if the groupTypeId exists, if not, an exception is thrown.
     * @author Sharon Barrial Marin
     */

    @Override
    public Optional<Song> handle(CreateSongCommand command) {
        if (songRepository.existsByNameAndSingerAndGroupNameAndRythmId(command.name(), command.singer(), command.groupName(), command.rythmId())) {
            throw new RuntimeException("Song with same attributes (Name, Singer, Group, RythmId) already exists");
        }

        if (!rythmTypeRepository.existsById(command.rythmId()))
            throw new RuntimeException("RythmType with id does not exist");

        var song = new Song (command);
        return Optional.of(songRepository.save(song));
    }
}
