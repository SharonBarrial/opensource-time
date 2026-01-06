package com.spotify.platform.u202317002.inventories.interfaces.rest;

import com.spotify.platform.u202317002.inventories.domain.models.commands.CreateSongCommand;
import com.spotify.platform.u202317002.inventories.domain.services.SongCommandService;
import com.spotify.platform.u202317002.inventories.interfaces.rest.resources.CreateSongResource;
import com.spotify.platform.u202317002.inventories.interfaces.rest.resources.SongResource;
import com.spotify.platform.u202317002.inventories.interfaces.rest.transform.CreateSongCommandFromResourceAssembler;
import com.spotify.platform.u202317002.inventories.interfaces.rest.transform.SongResourceFromEntityAssembler;
import com.spotify.platform.u202317002.shared.interfaces.rest.resources.MessageResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/songs")
public class SongController {

    private final SongCommandService songCommandService;
    private final CreateSongCommandFromResourceAssembler createSongCommandFromResourceAssembler;
    private final SongResourceFromEntityAssembler songResourceFromEntityAssembler;

    @Autowired
    public SongController(SongCommandService songCommandService,
                          CreateSongCommandFromResourceAssembler createSongCommandFromResourceAssembler,
                          SongResourceFromEntityAssembler songResourceFromEntityAssembler) {
        this.songCommandService = songCommandService;
        this.createSongCommandFromResourceAssembler = createSongCommandFromResourceAssembler;
        this.songResourceFromEntityAssembler = songResourceFromEntityAssembler;
    }

    @PostMapping
    public ResponseEntity<Object> addSong(@RequestBody CreateSongResource resource) {
        try {
            CreateSongCommand command = createSongCommandFromResourceAssembler.toCommand(resource);
            var songOptional = songCommandService.handle(command);

            if (songOptional.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new MessageResource("Song with same details already exists."));
            }

            SongResource songResource = songResourceFromEntityAssembler.toResource(songOptional.get());
            return ResponseEntity.status(HttpStatus.CREATED).body(songResource);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new MessageResource(e.getMessage()));
        }
    }
}
