package com.leedarson.platform.u202120430.devices.domain.model.entities;

import com.leedarson.platform.u202120430.devices.domain.model.valueobjects.SensorTypeName;
import jakarta.persistence.*;
import lombok.*;

/**
 * Sensor type entity
 * Author: Nadia Alessandra Lucas Coronel
 * Version: 1.0
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@With
public class SensorType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private SensorTypeName name;

    /**
     * Constructor
     * @param name Sensor type name
     */
    public SensorType(SensorTypeName name) {
        this.name = name;
    }
}