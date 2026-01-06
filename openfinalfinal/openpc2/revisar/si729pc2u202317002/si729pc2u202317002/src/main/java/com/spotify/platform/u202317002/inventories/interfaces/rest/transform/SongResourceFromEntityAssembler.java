package com.spotify.platform.u202317002.inventories.interfaces.rest.transform;

import com.spotify.platform.u202317002.inventories.domain.models.agreggates.Song;
import com.spotify.platform.u202317002.inventories.interfaces.rest.resources.SongResource;
import org.springframework.stereotype.Component;

@Component
public class SongResourceFromEntityAssembler {

    public SongResource toResource(Song song) {
        return new SongResource(
                song.getId(),
                song.getName(),
                song.getSinger(),
                song.getGroup(),
                song.getRhythm().getName().name().toLowerCase(),
                song.getYear().toString()
        );
    }
}