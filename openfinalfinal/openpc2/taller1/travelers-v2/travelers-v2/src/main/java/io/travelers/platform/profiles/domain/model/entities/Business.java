package io.travelers.platform.profiles.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Business(String name) {
        this.name = name;
    }

    public Business() {
    }

    public Long getBusinessId(){
        return id;
    }

}
