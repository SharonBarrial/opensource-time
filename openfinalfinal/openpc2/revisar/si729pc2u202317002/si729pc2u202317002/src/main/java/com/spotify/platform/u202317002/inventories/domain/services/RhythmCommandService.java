package com.spotify.platform.u202317002.inventories.domain.services;

import com.spotify.platform.u202317002.inventories.domain.models.commands.SeedRhythmsCommand;

public interface RhythmCommandService {
    void handle(SeedRhythmsCommand command);
}
