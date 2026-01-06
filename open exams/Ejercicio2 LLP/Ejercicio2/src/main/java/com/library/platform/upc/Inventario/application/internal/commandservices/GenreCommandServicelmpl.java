package com.library.platform.upc.Inventario.application.internal.commandservices;


import com.library.platform.upc.Inventario.domain.model.aggregates.Book;
import com.library.platform.upc.Inventario.domain.model.commands.SeedGenresCommand;
import com.library.platform.upc.Inventario.domain.model.entities.Genre;
import com.library.platform.upc.Inventario.domain.model.valueobjects.Genres;
import com.library.platform.upc.Inventario.domain.services.GenreCommandService;
import com.library.platform.upc.Inventario.infrastructure.persistence.jpa.GenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class GenreCommandServicelmpl implements GenreCommandService {
    private final GenreRepository genreRepository;


    public GenreCommandServicelmpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public void handle(SeedGenresCommand command) {
        Arrays.stream(Genres.values()).forEach(genre -> {
            if (!genreRepository.existsByName(genre)) {
                genreRepository.save(new Genre(Genres.valueOf(genre.name())));
            }
        });
    }
}
