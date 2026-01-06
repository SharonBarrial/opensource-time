package com.spotify.platform.u202317002.inventories.application.internal.commandservices;

import com.spotify.platform.u202317002.inventories.domain.models.agreggates.Song;
import com.spotify.platform.u202317002.inventories.domain.models.commands.CreateSongCommand;
import com.spotify.platform.u202317002.inventories.domain.models.entities.Rhythm;
import com.spotify.platform.u202317002.inventories.infrastructure.persistence.jpa.repositories.RhythmRepository;
import com.spotify.platform.u202317002.inventories.infrastructure.persistence.jpa.repositories.SongRepository;
import com.spotify.platform.u202317002.inventories.domain.services.SongCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongCommandServiceImpl implements SongCommandService {

    private final SongRepository songRepository;
    private final RhythmRepository rhythmRepository;

    @Autowired
    public SongCommandServiceImpl(SongRepository songRepository, RhythmRepository rhythmRepository) {
        this.songRepository = songRepository;
        this.rhythmRepository = rhythmRepository;
    }

    @Override
    public Optional<Song> handle(CreateSongCommand command) {
        if (songRepository.existsByNameAndSingerAndGroupAndRhythm_Id(
                command.name(), command.singer(), command.group(), command.rhythmId())) {
            return Optional.empty();
        }

        Rhythm rhythm = rhythmRepository.findById(command.rhythmId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid rhythm ID"));

        Song song = new Song(command.name(), command.singer(), command.group(), rhythm, command.year());
        songRepository.save(song);

        return Optional.of(song);
    }
}