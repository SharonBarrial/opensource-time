package com.spotify.platform.u202114900.inventories.domain.models.command;

import java.util.Date;

public record CreateSongCommand(
        String name,
        String singer,
        String groupName,
        Date year,
        Long rythmId) {
}
