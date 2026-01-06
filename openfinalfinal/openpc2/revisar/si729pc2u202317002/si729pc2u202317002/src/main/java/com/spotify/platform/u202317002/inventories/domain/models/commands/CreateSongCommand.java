package com.spotify.platform.u202317002.inventories.domain.models.commands;

import java.util.Date;

public record CreateSongCommand(
        String name,
        String singer,
        String group,
        Long rhythmId,
        Date year
) {

    /**
     * @summary Record as Command to create a Song, with validation rules
     * @param name can't be null, must be less than 50 characters
     * @param singer can't be null, must be less than 80 characters
     * @param group can't be null, must be less than 100 characters
     * @param rhythmId can't be null
     * @param year can't be null
     * @author Joseph Llacchua
     */
    public CreateSongCommand {
        if (name == null || name.isBlank() || name.length() > 50) {
            throw new RuntimeException("Name is required and must be less than 50 characters");
        }
        if (singer == null || singer.isBlank() || singer.length() > 80) {
            throw new IllegalArgumentException("Singer is required and must be less than 80 characters");
        }
        if (group == null || group.isBlank() || group.length() > 100) {
            throw new IllegalArgumentException("Group is required and must be less than 100 characters");
        }
        if (rhythmId == null) {
            throw new IllegalArgumentException("Rhythm ID is required");
        }
        if (year == null) {
            throw new IllegalArgumentException("Year is required");
        }
    }
}