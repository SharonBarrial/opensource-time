package com.spotify.platform.u202114900.inventories.domain.services;

import com.spotify.platform.u202114900.inventories.domain.models.aggregates.Song;
import com.spotify.platform.u202114900.inventories.domain.models.command.CreateSongCommand;

import java.util.Optional;

public interface SongCommandServices {
    Optional<Song> handle(CreateSongCommand command);
}
