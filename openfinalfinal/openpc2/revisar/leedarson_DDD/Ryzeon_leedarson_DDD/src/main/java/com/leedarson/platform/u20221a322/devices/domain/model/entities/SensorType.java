package com.leedarson.platform.u20221a322.devices.domain.model.entities;

import com.leedarson.platform.u20221a322.devices.domain.model.valueobjects.SensorTypes;
import jakarta.persistence.*;
import lombok.Getter;

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: leedarson
 * Date: 12/06/24 @ 01:08
 */
@Entity
public class SensorType {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false, unique = true)
    private SensorTypes name;

    public SensorType() {
    }

    public SensorType(SensorTypes sensorType) {
        this.name = sensorType;
    }

    public static SensorType toSensorTypeFromName(String name) {
        return new SensorType(SensorTypes.valueOf(name));
    }
}
