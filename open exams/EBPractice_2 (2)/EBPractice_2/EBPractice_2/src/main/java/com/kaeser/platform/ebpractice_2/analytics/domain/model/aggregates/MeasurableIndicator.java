package com.kaeser.platform.ebpractice_2.analytics.domain.model.aggregates;

import com.kaeser.platform.ebpractice_2.analytics.domain.model.commands.CreateMeasurableIndicatorCommand;
import com.kaeser.platform.ebpractice_2.analytics.domain.model.valueobjects.Description;
import com.kaeser.platform.ebpractice_2.analytics.domain.model.valueobjects.Symbol;
import com.kaeser.platform.ebpractice_2.analytics.domain.model.valueobjects.ThresholdMaximum;
import com.kaeser.platform.ebpractice_2.analytics.domain.model.valueobjects.ThresholdMinimum;
import com.kaeser.platform.ebpractice_2.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.kaeser.platform.ebpractice_2.shared.domain.model.entities.EquipmentType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 * MeasurableIndicator - Domain Model
 *
 * @author Fiorella Jarama Peñaloza
 */
@Getter
@Setter
@Entity
public class MeasurableIndicator extends AuditableAbstractAggregateRoot<MeasurableIndicator> {

    @Embedded
    private Symbol symbol;

    @Embedded
    private Description description;

    @Embedded
    private ThresholdMaximum thresholdMaximum;

    @Embedded
    private ThresholdMinimum thresholdMinimum;

    @ManyToOne
    @JoinColumn(name = "equipmentType_id")
    private EquipmentType equipmentType;

    public MeasurableIndicator() {
    }

    public MeasurableIndicator(Symbol symbol, Description description, ThresholdMaximum thresholdMaximum, ThresholdMinimum thresholdMinimum, EquipmentType equipmentType) {
        this.symbol = symbol;
        this.description = description;
        this.thresholdMaximum = thresholdMaximum;
        this.thresholdMinimum = thresholdMinimum;
        this.equipmentType = equipmentType;
    }

    public MeasurableIndicator(CreateMeasurableIndicatorCommand command, EquipmentType equipmentType) {
        this.symbol = new Symbol(command.symbol());
        this.description = new Description(command.description());
        this.thresholdMaximum = new ThresholdMaximum(command.thresholdMaximum());
        this.thresholdMinimum = new ThresholdMinimum(command.thresholdMinimum());
        this.equipmentType = equipmentType;
    }

    //getters
    public String getSymbol() {
        return symbol.symbol();
    }

    public String getDescription() {
        return description.description();
    }

    public Double getThresholdMaximum() {
        return thresholdMaximum.thresholdMaximum();
    }

    public Double getThresholdMinimum() {
        return thresholdMinimum.thresholdMinimum();
    }

    public String getEquipmentTypeName() {
        return equipmentType.getType().name();
    }

}
