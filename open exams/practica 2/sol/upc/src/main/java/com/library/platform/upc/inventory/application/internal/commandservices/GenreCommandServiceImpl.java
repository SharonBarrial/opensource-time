package com.library.platform.upc.inventory.application.internal.commandservices;

import com.library.platform.upc.inventory.domain.model.commands.PopulateGenresCommand;
import com.library.platform.upc.inventory.domain.model.entities.Genre;
import com.library.platform.upc.inventory.domain.model.valueobjects.Genres;
import com.library.platform.upc.inventory.domain.services.GenreCommandService;
import com.library.platform.upc.inventory.infrastructure.persistence.jpa.repositories.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class GenreCommandServiceImpl implements GenreCommandService {
    private final GenreRepository genreRepository;

    public GenreCommandServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public void handle(PopulateGenresCommand populateGenreCommand) {
        Arrays.stream(Genres.values()).forEach(genreType -> {
            if(!genreRepository.existsByName(genreType))
                genreRepository.save(new Genre(genreType));
        });
    }

}
