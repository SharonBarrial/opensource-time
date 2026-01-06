package com.isa.platform.u202120430.monitoring.domain.model.aggregates;

import com.isa.platform.u202120430.inventory.domain.model.aggregates.Product;
import com.isa.platform.u202120430.inventory.domain.model.commands.CreateProductCommand;
import com.isa.platform.u202120430.monitoring.domain.model.commands.CreateSnapshotCommand;
import com.isa.platform.u202120430.monitoring.domain.model.valueobjects.Energy;
import com.isa.platform.u202120430.monitoring.domain.model.valueobjects.Leakage;
import com.isa.platform.u202120430.monitoring.domain.model.valueobjects.ProductSerialNumber;
import com.isa.platform.u202120430.monitoring.domain.model.valueobjects.Temperature;
import com.isa.platform.u202120430.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */

@Getter
@Entity
@Setter
public class Snapshot extends AuditableAbstractAggregateRoot<Snapshot> {
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Embedded
    @NotNull
    private ProductSerialNumber productSerialNumber;

    @Embedded
    @NotNull
    private Temperature temperature;

    @Embedded
    @NotNull
    private Energy energy;

    @Embedded
    @NotNull
    private Leakage leakage;

    public Snapshot() {}

    public Snapshot(Product product, ProductSerialNumber productSerialNumber, Temperature temperature, Energy energy, Leakage leakage) {
        this();
        // this is a foreign key of Product
        this.product = product;
        this.productSerialNumber = productSerialNumber;
        this.temperature = temperature;
        this.energy = energy;
        this.leakage = leakage;
    }

    public Snapshot(CreateSnapshotCommand createSnapshotCommand, Product product) {
        this();
        this.product = product;
        this.productSerialNumber = new ProductSerialNumber(createSnapshotCommand.productSerialNumber());
        this.temperature = new Temperature(createSnapshotCommand.temperature());
        this.energy = new Energy(createSnapshotCommand.energy());
        this.leakage = new Leakage(createSnapshotCommand.leakage());
    }

    //getters
    public String getProductSerialNumber() {
        return productSerialNumber.productSerialNumber();
    }
    public Double getTemperature() {
        return temperature.temperature();
    }
    public Double getEnergy() {
        return energy.energy();
    }
    public Integer getLeakage() {
        return leakage.leakage();
    }
}
