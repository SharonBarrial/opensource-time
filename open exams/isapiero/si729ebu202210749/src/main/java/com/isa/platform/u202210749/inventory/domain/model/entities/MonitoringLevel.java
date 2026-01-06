package com.isa.platform.u202210749.inventory.domain.model.entities;

import com.isa.platform.u202210749.inventory.domain.model.valueobjects.MonitoringLevels;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class MonitoringLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false, unique = true)
    private MonitoringLevels name;

    public MonitoringLevel() {}

    public MonitoringLevel(MonitoringLevels name) {
        this.name = name;
    }

    public String getName() {
        return this.name.name();
    }

    public static MonitoringLevel toMonitorLevelFromName(String name) {
        return new MonitoringLevel(MonitoringLevels.valueOf(name));
    }
}
