package com.library.platform.upc.inventory.domain.services;

import com.library.platform.upc.inventory.domain.model.commands.PopulateGenresCommand;

public interface GenreCommandService {
    void handle(PopulateGenresCommand populateGenresCommand);
}
