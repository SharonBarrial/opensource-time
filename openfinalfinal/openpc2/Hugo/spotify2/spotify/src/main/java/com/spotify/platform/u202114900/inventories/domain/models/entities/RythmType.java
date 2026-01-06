package com.spotify.platform.u202114900.inventories.domain.models.entities;

import com.spotify.platform.u202114900.inventories.domain.models.valueobjects.RythmTypes;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class RythmType {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false, unique = true)
    private RythmTypes name;

    public RythmType() {
    }

    public RythmType(RythmTypes rythmTypes){this.name = rythmTypes;}

    public static RythmType toSensorTypeFromName(String name) {
        return new RythmType(RythmTypes.valueOf(name));
    }

}
