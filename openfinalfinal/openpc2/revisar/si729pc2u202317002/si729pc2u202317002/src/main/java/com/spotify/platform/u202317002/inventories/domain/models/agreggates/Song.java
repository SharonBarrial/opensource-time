package com.spotify.platform.u202317002.inventories.domain.models.agreggates;

import com.spotify.platform.u202317002.inventories.domain.models.entities.Rhythm;
import com.spotify.platform.u202317002.inventories.domain.models.valueobjets.Rhythms;
import com.spotify.platform.u202317002.shared.domain.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.Date;

@Entity
public class Song extends AuditableAbstractAggregateRoot<Song> {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Size(max = 50)
    @NotBlank
    @Column(length = 50, nullable = false)
    private String name;

    @Getter
    @Size(max = 80)
    @NotBlank
    @Column(length = 80, nullable = false)
    private String singer;

    @Getter
    @Size(max = 100)
    @NotBlank
    @Column(name = "group_?", length = 100, nullable = false)
    private String group;

    @Getter
    @ManyToOne
    @JoinColumn(name = "rhythm_id", nullable = false)

    private Rhythm rhythm = new Rhythm(Rhythms.Salsa);

    @Getter
    @Column(nullable = false)
    private Date year;

    public Song() {
    }

    public Song(String name, String singer, String group, Rhythm rhythm, Date year) {
        this.name = name;
        this.singer = singer;
        this.group = group;
        this.rhythm = rhythm;
        this.year = year;
    }
}