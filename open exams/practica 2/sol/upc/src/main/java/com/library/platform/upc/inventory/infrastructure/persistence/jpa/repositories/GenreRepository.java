package com.library.platform.upc.inventory.infrastructure.persistence.jpa.repositories;

import com.library.platform.upc.inventory.domain.model.entities.Genre;
import com.library.platform.upc.inventory.domain.model.valueobjects.Genres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    boolean existsByName(Genres name);
}
