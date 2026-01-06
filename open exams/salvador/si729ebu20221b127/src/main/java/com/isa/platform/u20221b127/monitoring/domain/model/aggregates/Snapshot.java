package com.isa.platform.u20221b127.monitoring.domain.model.aggregates;

import com.isa.platform.u20221b127.inventory.domain.model.aggregates.Product;
import com.isa.platform.u20221b127.monitoring.domain.model.commands.CreateSnapshotCommand;
import com.isa.platform.u20221b127.monitoring.domain.model.valueobjects.Energy;
import com.isa.platform.u20221b127.monitoring.domain.model.valueobjects.Leakage;
import com.isa.platform.u20221b127.monitoring.domain.model.valueobjects.Temperature;
import com.isa.platform.u20221b127.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * Snapshot Entity
 * <p>
 *     This class represents the Snapshot entity in the domain model.
 *     It contains the snapshot id, product serial number, temperature, energy, and leakage of the snapshot.
 * </p>
 * @author Salvador Salinas
 * @version 1.0
 */
@Entity
public class Snapshot extends AuditableAbstractAggregateRoot<Snapshot> {
    @NotNull
    @NotBlank
    private String snapshotId;

    @NotNull
    @NotBlank
    private String productSerialNumber;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Embedded
    @NotNull
    private Temperature temperature;

    // Mandatory only for Products with Advance Monitoring Level
    @Embedded
    private Energy energy;

    // Mandatory only for Products with Advance Monitoring Level
    @Embedded
    private Leakage leakage;

    public Snapshot() {}

    public Snapshot(CreateSnapshotCommand command, Product product) {
        this.snapshotId = command.snapshotId();
        this.product = product;
        this.productSerialNumber = product.getSerialNumber();
        this.temperature = new Temperature(command.temperature());
        if (Objects.equals(product.getMonitoringLevel(), "ADVANCE_MONITORING")) {
            this.energy = new Energy(command.energy());
            this.leakage = new Leakage(command.leakage());
        }
    }

    public String getSnapshotId() {
        return snapshotId;
    }

    public String getProductSerialNumber() {
        return productSerialNumber;
    }

    public Product getProduct() {
        return product;
    }

    public Double getTemperature() {
        return temperature.temperature();
    }

    public Double getEnergy() {
        return energy != null ? energy.energy() : null;
    }

    public Integer getLeakage() {
        return leakage != null ? leakage.leakage() : null;
    }

}
