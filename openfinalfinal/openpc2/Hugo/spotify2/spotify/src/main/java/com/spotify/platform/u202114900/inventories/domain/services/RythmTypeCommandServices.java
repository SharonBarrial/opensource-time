package com.spotify.platform.u202114900.inventories.domain.services;

import com.spotify.platform.u202114900.inventories.domain.models.command.SeendRythmTypeCommands;

public interface RythmTypeCommandServices {

    void handle(SeendRythmTypeCommands command);
}
