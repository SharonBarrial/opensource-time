package com.spotify.platform.u202114900.inventories.interfaces.rest;

import com.spotify.platform.u202114900.inventories.domain.services.SongCommandServices;
import com.spotify.platform.u202114900.inventories.interfaces.rest.resources.CreateSongResource;
import com.spotify.platform.u202114900.inventories.interfaces.rest.resources.SongResource;
import com.spotify.platform.u202114900.inventories.interfaces.rest.transform.CreateSongCommandFromResource;
import com.spotify.platform.u202114900.inventories.interfaces.rest.transform.SongResourceFromEntityAsembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@RequestMapping(value = "/api/v1/songs", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Song", description = "Song Controller")
public class SongController {

    private final SongCommandServices songCommandServices;

    public SongController(SongCommandServices songCommandServices) {
        this.songCommandServices = songCommandServices;
    }

    /**
     * @param resource CreateSongResource
     * @summary Receives a resource, transforms it into a command, and it's handled by the service
     * @return SensorResource as response with status CREATED (201)
     * @author Sharon Barrial Marin
     */

    @PostMapping
    public ResponseEntity<SongResource> createSong(@RequestBody CreateSongResource resource) {
        var createSongCommand = CreateSongCommandFromResource.toCommandFromResource(resource);
        var songEntity = songCommandServices.handle(createSongCommand);
        if (songEntity.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var songResource = SongResourceFromEntityAsembler.toResourceFromEntity(songEntity.get());
        return new ResponseEntity<>(songResource, HttpStatus.CREATED);
    }
}
