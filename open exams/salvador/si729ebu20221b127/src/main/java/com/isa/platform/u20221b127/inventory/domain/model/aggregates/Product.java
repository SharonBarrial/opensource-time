package com.isa.platform.u20221b127.inventory.domain.model.aggregates;

import com.isa.platform.u20221b127.inventory.domain.model.commands.CreateProductCommand;
import com.isa.platform.u20221b127.inventory.domain.model.valueobjects.Brand;
import com.isa.platform.u20221b127.inventory.domain.model.valueobjects.Model;
import com.isa.platform.u20221b127.inventory.domain.model.valueobjects.MonitoringLevel;
import com.isa.platform.u20221b127.inventory.domain.model.valueobjects.SerialNumber;
import com.isa.platform.u20221b127.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

/**
 * Product Entity
 * <p>
 *     This class represents the Product entity in the domain model.
 *     It contains the brand, model, serial number, and monitoring level of the product.
 * </p>
 * @author Salvador Salinas
 * @version 1.0
 */
@Entity
public class Product extends AuditableAbstractAggregateRoot<Product> {
    @Embedded
    @NotNull
    private Brand brand;

    @Embedded
    @NotNull
    private Model model;

    @Embedded
    @NotNull
    private SerialNumber serialNumber;

    @Enumerated(EnumType.STRING)
    @NotNull
    private MonitoringLevel monitoringLevel;

    public Product() {}

    public Product(Brand brand, Model model, SerialNumber serialNumber, MonitoringLevel monitoringLevel) {
        this.brand = brand;
        this.model = model;
        this.serialNumber = serialNumber;
        this.monitoringLevel = monitoringLevel;
    }

    public Product(CreateProductCommand command) {
        this.brand = new Brand(command.brand());
        this.model = new Model(command.model());
        this.serialNumber = new SerialNumber(command.serialNumber());
        this.monitoringLevel = MonitoringLevel.valueOf(command.monitoringLevel().toUpperCase());
    }

    public String getBrand() {
        return brand.brand();
    }

    public String getModel() {
        return model.model();
    }

    public String getSerialNumber() {
        return serialNumber.serialNumber();
    }

    public String getMonitoringLevel() {
        return monitoringLevel.name();
    }
}
