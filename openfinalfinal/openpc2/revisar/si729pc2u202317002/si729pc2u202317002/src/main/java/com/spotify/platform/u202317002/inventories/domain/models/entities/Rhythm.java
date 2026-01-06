package com.spotify.platform.u202317002.inventories.domain.models.entities;

import com.spotify.platform.u202317002.inventories.domain.models.valueobjets.Rhythms;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "rhythms_types")
    public class Rhythm {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Enumerated(EnumType.STRING)
    private Rhythms name;

    public Rhythm()
    {
    }
    public Rhythm(Rhythms rhythms)
    {
        this.name = rhythms;
    }
    public  static Rhythm toRhythmFromName(String name){
        return new Rhythm(Rhythms.valueOf(name));
    }
}
