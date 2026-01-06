package com.spotify.platform.u202317002.inventories.interfaces.rest.resources;

public record SongResource(
        Long id,
        String name,
        String singer,
        String group,
        String rhythm,
        String year
) {}