package com.library.platform.upc.inventory.domain.model.entities;

import com.library.platform.upc.inventory.domain.model.valueobjects.Genres;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false, unique = true)
    private Genres name;

    public Genre() {}

    public Genre(Genres name) {
        this.name = name;
    }

    public String getName() {
        return this.name.name();
    }

    public static Genre toGenreFromName(String name) {
        return new Genre(Genres.valueOf(name));
    }
}
