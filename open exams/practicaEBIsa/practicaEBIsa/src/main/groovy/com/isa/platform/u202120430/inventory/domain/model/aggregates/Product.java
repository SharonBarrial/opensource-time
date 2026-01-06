package com.isa.platform.u202120430.inventory.domain.model.aggregates;

import com.isa.platform.u202120430.inventory.domain.model.commands.CreateProductCommand;
import com.isa.platform.u202120430.inventory.domain.model.valueobjects.Brand;
import com.isa.platform.u202120430.inventory.domain.model.valueobjects.Model;
import com.isa.platform.u202120430.inventory.domain.model.valueobjects.SerialNumber;
import com.isa.platform.u202120430.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.isa.platform.u202120430.shared.domain.model.entities.MonitoringLevel;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */

@Getter
@Entity
@Setter
public class Product extends AuditableAbstractAggregateRoot<Product> {
    @Embedded
    private Brand brand;

    @Embedded
    private Model model;

    @Embedded
    private SerialNumber serialNumber;

    @ManyToOne
    @JoinColumn(name = "monitoringLevel_id")
    private MonitoringLevel monitoringLevel;

    public Product() {}

    public Product(Brand brand, Model model, SerialNumber serialNumber, MonitoringLevel monitoringLevel) {
        this();
        this.brand = brand;
        this.model = model;
        this.serialNumber = serialNumber;
        // this is a foreign key of MonitoringLevel
        this.monitoringLevel = monitoringLevel;
    }

    public Product(CreateProductCommand createProductCommand, MonitoringLevel monitoringLevel) {
        this();
        this.brand = new Brand(createProductCommand.brand());
        this.model = new Model(createProductCommand.model());
        this.serialNumber = new SerialNumber(createProductCommand.serialNumber());
        // this is a foreign key of MonitoringLevel
        this.monitoringLevel = monitoringLevel;
    }

    //getters
    public String getBrand() {
        return brand.brand();
    }
    public String getModel() {
        return model.model();
    }
    public String getSerialNumber() {
        return serialNumber.serialNumber();
    }

    public MonitoringLevel getMonitoringLevel() {
        return monitoringLevel;
    }
}
