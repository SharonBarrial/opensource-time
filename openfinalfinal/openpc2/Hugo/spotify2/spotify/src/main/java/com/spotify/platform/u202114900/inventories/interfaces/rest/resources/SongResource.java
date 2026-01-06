package com.spotify.platform.u202114900.inventories.interfaces.rest.resources;

import java.util.Date;

public record SongResource(
        String name,
        String singer,
        String groupName,
        Date year,
        Long rythmId) {
}
