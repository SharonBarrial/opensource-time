package com.spotify.platform.u202317002.inventories.interfaces.rest.transform;

import com.spotify.platform.u202317002.inventories.domain.models.commands.CreateSongCommand;
import com.spotify.platform.u202317002.inventories.interfaces.rest.resources.CreateSongResource;
import org.springframework.stereotype.Component;

@Component
public class CreateSongCommandFromResourceAssembler {

    public CreateSongCommand toCommand(CreateSongResource resource) {
        return new CreateSongCommand(
                resource.name(),
                resource.singer(),
                resource.group(),
                resource.rhythmId(),
                java.sql.Date.valueOf(resource.year())
        );
    }
}