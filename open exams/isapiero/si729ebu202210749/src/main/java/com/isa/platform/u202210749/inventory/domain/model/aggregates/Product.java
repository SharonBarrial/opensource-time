package com.isa.platform.u202210749.inventory.domain.model.aggregates;

import com.isa.platform.u202210749.inventory.domain.model.commands.CreateProductCommand;
import com.isa.platform.u202210749.inventory.domain.model.entities.MonitoringLevel;
import com.isa.platform.u202210749.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Entity
public class Product extends AuditableAbstractAggregateRoot<Product> {
    @NotNull(message = "Brand is required")
    @Getter
    private String brand;

    @NotNull(message = "Model is required")
    @Getter
    private String model;

    @NotNull(message = "Serial number is required")
    @Getter
    @Column(unique = true)
    private String serialNumber;

    @ManyToOne
    @JoinColumn(name = "monitoring_level_id", nullable = false)
    @Getter
    private MonitoringLevel monitoringLevel;

    public Product() {}

    public Product(CreateProductCommand command, MonitoringLevel monitoringLevel){
        this.brand = command.brand();
        this.model = command.model();
        this.serialNumber = command.serialNumber();
        this.monitoringLevel = monitoringLevel;
    }
}
