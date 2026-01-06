package com.spotify.platform.u202317002.inventories.interfaces.rest.resources;

public record CreateSongResource(
        String name,
        String singer,
        String group,
        Long rhythmId,
        String year
) {}