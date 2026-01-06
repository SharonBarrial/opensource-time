package com.spotify.platform.u202317002.inventories.domain.services;

import com.spotify.platform.u202317002.inventories.domain.models.commands.CreateSongCommand;
import com.spotify.platform.u202317002.inventories.domain.models.agreggates.Song;

import java.util.Optional;

public interface SongCommandService {
    Optional<Song> handle(CreateSongCommand command);
}