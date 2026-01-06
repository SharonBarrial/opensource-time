package com.leedarson.platform.u20221a322.devices.domain.model.aggregates;

import com.leedarson.platform.u20221a322.devices.domain.model.commands.CreateSensorCommand;
import com.leedarson.platform.u20221a322.shared.domain.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: leedarson
 * Date: 12/06/24 @ 01:32
 */
@Entity
public class Sensor extends AuditableAbstractAggregateRoot<Sensor> {

    @Getter
    @Size(max = 50)
    @NotBlank
    @Column(length = 50, nullable = false)
    private String name;

    @Getter
    @NotBlank
    @Column(nullable = false)
    private Long sensorTypeId;

    @Getter
    @Size(max = 360)
    @NotBlank
    @Column(length = 360, nullable = false)
    private String description;

    @Getter
    @Size(max = 100)
    @NotBlank
    @Column(length = 100, nullable = false)
    private String manufacturer;

    @Getter
    @NotBlank
    @Column(nullable = false)
    private String referenceImageUrl;

    public Sensor() {
    }

    public Sensor(String name, Long sensorTypeId, String description, String manufacturer, String referenceImageUrl) {
        this.name = name;
        this.sensorTypeId = sensorTypeId;
        this.description = description;
        this.manufacturer = manufacturer;
        this.referenceImageUrl = referenceImageUrl;
    }

    public Sensor(CreateSensorCommand command) {
        this.name = command.name();
        this.sensorTypeId = command.sensorTypeId();
        this.description = command.description();
        this.manufacturer = command.manufacturer();
        this.referenceImageUrl = command.referenceImageUrl();
    }
}
