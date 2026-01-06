package com.spotify.platform.u202114900.inventories.interfaces.rest.transform;

import com.spotify.platform.u202114900.inventories.domain.models.command.CreateSongCommand;
import com.spotify.platform.u202114900.inventories.interfaces.rest.resources.CreateSongResource;

public class CreateSongCommandFromResource {

    public static CreateSongCommand toCommandFromResource(CreateSongResource resource) {
        return new CreateSongCommand(
                resource.name(),
                resource.singer(),
                resource.groupName(),
                resource.year(),
                resource.rythmId()
        );
    }
}
