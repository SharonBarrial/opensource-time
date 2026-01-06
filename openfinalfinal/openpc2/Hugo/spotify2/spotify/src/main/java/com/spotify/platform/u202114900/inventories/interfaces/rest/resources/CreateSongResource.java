package com.spotify.platform.u202114900.inventories.interfaces.rest.resources;

import java.util.Date;

public record CreateSongResource(String name,
                                 String singer,
                                 String groupName,
                                 Long rythmId,
                                 Date year) {
}
