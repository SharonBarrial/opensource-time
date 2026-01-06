package com.kaeser.platform.u202114900.analytics.domain.model.aggregates;

import com.kaeser.platform.u202114900.analytics.domain.model.commands.CreateMeasurableIndicatorCommand;
import com.kaeser.platform.u202114900.analytics.domain.model.valueobjects.Description;
import com.kaeser.platform.u202114900.analytics.domain.model.valueobjects.Symbol;
import com.kaeser.platform.u202114900.analytics.domain.model.valueobjects.ThresholdMaximum;
import com.kaeser.platform.u202114900.analytics.domain.model.valueobjects.ThresholdMinimum;
import com.kaeser.platform.u202114900.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.kaeser.platform.u202114900.shared.domain.model.entities.EquipmentType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 * Measurable Indicator entity.
 * <p>
 *     This class represents the measurable indicator entity.
 *     It contains the symbol, description, threshold maximum, threshold minimum, and equipment type.
 *     It also contains the getters for the symbol, description, threshold maximum, threshold minimum, and equipment type.
 *     It contains a constructor, a constructor with parameters, and a constructor with a CreateMeasurableIndicatorCommand command and an EquipmentType equipmentType.
 *     It also contains the getters for the symbol, description, threshold maximum, threshold minimum, and equipment type.
 *     It contains the getters for the symbol, description, threshold maximum, threshold minimum, and equipment type.
 * </p>
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */

@Getter
@Setter
@Entity
public class MeasurableIndicator extends AuditableAbstractAggregateRoot<MeasurableIndicator>{
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

    /**
     * Constructor
     * <p>
     *     Constructor method.
     *     It creates a new instance of MeasurableIndicator.
     *     It does not receive any parameters.
     *     It is empty.
     *     It is used to create a new instance of MeasurableIndicator.
     * </p>
     */

    public MeasurableIndicator() {
    }

    public MeasurableIndicator(Symbol symbol, Description description, ThresholdMaximum thresholdMaximum, ThresholdMinimum thresholdMinimum, EquipmentType equipmentType) {
        this.symbol = symbol;
        this.description = description;
        this.thresholdMaximum = thresholdMaximum;
        this.thresholdMinimum = thresholdMinimum;
        this.equipmentType = equipmentType;
    }

    /**
     * Constructor with parameters
     * <p>
     *     Constructor method.
     *     It creates a new instance of MeasurableIndicator.
     *     It receives the symbol, description, threshold maximum, threshold minimum, and equipment type.
     *     It is used to create a new instance of MeasurableIndicator with the given parameters.
     * </p>
     * @param command CreateMeasurableIndicatorCommand
     * @param equipmentType EquipmentType
     */

    public MeasurableIndicator(CreateMeasurableIndicatorCommand command, EquipmentType equipmentType) {
        this.symbol = new Symbol(command.symbol());
        this.description = new Description(command.description());
        this.thresholdMaximum = new ThresholdMaximum(command.thresholdMaximum());
        this.thresholdMinimum = new ThresholdMinimum(command.thresholdMinimum());
        this.equipmentType = equipmentType;
    }

    //Getters

    /**
     * Getters
     * <p>
     *     Getter methods.
     *     They return the symbol, description, threshold maximum, threshold minimum, and equipment type.
     *     They are used to get the symbol, description, threshold maximum, threshold minimum, and equipment type.
     *     They do not receive any parameters.
     *     They return the symbol, description, threshold maximum, threshold minimum, and equipment type.
     *</p>
     */

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
