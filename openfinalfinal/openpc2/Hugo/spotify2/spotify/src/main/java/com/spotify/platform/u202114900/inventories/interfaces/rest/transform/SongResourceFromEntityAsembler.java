package com.spotify.platform.u202114900.inventories.interfaces.rest.transform;

import com.spotify.platform.u202114900.inventories.domain.models.aggregates.Song;
import com.spotify.platform.u202114900.inventories.interfaces.rest.resources.SongResource;

public class SongResourceFromEntityAsembler {

    public static SongResource toResourceFromEntity(Song song) {
        return new SongResource(
                song.getName(),
                song.getSinger(),
                song.getGroupName(),
                song.getYear(),
                song.getRythmId());
    }
}
