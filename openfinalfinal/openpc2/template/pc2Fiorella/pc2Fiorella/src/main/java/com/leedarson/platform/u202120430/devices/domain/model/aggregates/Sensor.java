package com.leedarson.platform.u202120430.devices.domain.model.aggregates;

import com.leedarson.platform.u202120430.devices.domain.model.commands.CreateSensorCommand;
import com.leedarson.platform.u202120430.devices.domain.model.entities.SensorType;
import com.leedarson.platform.u202120430.devices.domain.model.valueobjects.Description;
import com.leedarson.platform.u202120430.devices.domain.model.valueobjects.Manufacturer;
import com.leedarson.platform.u202120430.devices.domain.model.valueobjects.Name;
import com.leedarson.platform.u202120430.devices.domain.model.valueobjects.ReferenceImageUrl;
import com.leedarson.platform.u202120430.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Sensor Aggregate Root
 * @author Nadia Alessandra Lucas Coronel
 * @version 1.0
 */

@Getter
@Setter
@Entity
public class Sensor extends AuditableAbstractAggregateRoot<Sensor> {
    @Embedded
    private Name name;

    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private SensorType sensorType;

    @Embedded
    private Description description;

    @Embedded
    private Manufacturer manufacturer;

    @Embedded
    private ReferenceImageUrl referenceImageUrl;

    public Sensor() {}

    /**
     * Constructor
     * @param name Sensor name
     * @param sensorType Sensor type
     * @param description Sensor description
     * @param manufacturer Sensor manufacturer
     * @param referenceImageUrl Sensor reference image URL
     */
    public Sensor(Name name, SensorType sensorType, Description description, Manufacturer manufacturer, ReferenceImageUrl referenceImageUrl) {
        this();
        this.name = name;
        // this is a foreign key of SensorType
        this.sensorType = sensorType;
        this.description = description;
        this.manufacturer = manufacturer;
        this.referenceImageUrl = referenceImageUrl;
    }

    /**
     * Constructor
     * @param command Create sensor command
     * @param sensorType Sensor type
     */
    public Sensor(CreateSensorCommand command, SensorType sensorType){
        this();
        this.name = new Name(command.name());
        // this is a foreign key of SensorType
        this.sensorType = sensorType;
        this.description = new Description(command.description());
        this.manufacturer = new Manufacturer(command.manufacturer());
        this.referenceImageUrl = new ReferenceImageUrl(command.referenceImageUrl());
    }

    //Getters
    public String getName() {
        return name.name();
    }
    public String getDescription() {
        return description.description();
    }
    public String getManufacturer() {
        return manufacturer.manufacturer();
    }
    public String getReferenceImageUrl() {
        return referenceImageUrl.referenceImageUrl();
    }
}
