package com.library.platform.upc.Inventario.domain.model.entities;

import com.library.platform.upc.Inventario.domain.model.valueobjects.Genres;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.With;

import java.util.List;

@Getter
@Entity
@Data
@AllArgsConstructor
@With
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, length = 20)
    private Genres name;

    public Genre() {}

    public  Genre(Genres name){
        this.name = name;
    }
    public  String getStringName(){
        return name.name();
    }

    public static Genre getDefaultGenre(){
        return new Genre(Genres.FICTION);
    }

    public static Genre toGenreFromName(String name){
        return new Genre(Genres.valueOf(name));
    }
    public static List<Genre> validateGenreSet(List<Genre> genres){
        if(genres ==null || genres.isEmpty()){
           return List.of(getDefaultGenre());
        }
        return genres;
    }

}