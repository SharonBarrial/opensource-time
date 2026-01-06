package com.library.platform.upc.Inventario.domain.services;

import com.library.platform.upc.Inventario.domain.model.commands.SeedGenresCommand;


public interface GenreCommandService {
    void handle(SeedGenresCommand command);
}
