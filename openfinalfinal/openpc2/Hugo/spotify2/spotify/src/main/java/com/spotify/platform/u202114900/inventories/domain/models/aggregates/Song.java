package com.spotify.platform.u202114900.inventories.domain.models.aggregates;

import com.spotify.platform.u202114900.inventories.domain.models.command.CreateSongCommand;
import com.spotify.platform.u202114900.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.Date;

@Entity
public class Song  extends AuditableAbstractAggregateRoot<Song> {

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
    @Column(length = 100, nullable = false)
    private String groupName;

    @Getter
    @Column(nullable = false)
    private Long rythmId;

    @Getter
    @NotBlank
    @Column(nullable = false)
    private Date year;

    public Song() {
    }

    public Song(CreateSongCommand command){
        this.name = command.name();
        this.singer = command.singer();
        this.groupName = command.groupName();
        this.rythmId = command.rythmId();
        this.year = command.year();
    }

    public Song(String name, String singer, String name_group, Long rythmId, Date year) {
        this.name = name;
        this.singer = singer;
        this.groupName = groupName;
        this.rythmId = rythmId;
        this.year = year;
    }
}
