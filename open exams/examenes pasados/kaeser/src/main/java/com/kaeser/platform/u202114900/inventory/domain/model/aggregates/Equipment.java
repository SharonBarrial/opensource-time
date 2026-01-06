package com.kaeser.platform.u202114900.inventory.domain.model.aggregates;

import com.kaeser.platform.u202114900.inventory.domain.model.commands.CreateEquipmentCommand;
import com.kaeser.platform.u202114900.inventory.domain.model.valueobjects.MaterialSerialNumber;
import com.kaeser.platform.u202114900.inventory.domain.model.valueobjects.Model;
import com.kaeser.platform.u202114900.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.kaeser.platform.u202114900.shared.domain.model.entities.EquipmentType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Equipment entity.
 * <p>
 *     Represents the equipment.
 *     It contains the material serial number, model and equipment type.
 *     It extends the AuditableAbstractAggregateRoot class.
 *     It contains the constructors and the getters.
 * </p>
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */

@Getter
@Setter
@Entity
public class Equipment extends AuditableAbstractAggregateRoot<Equipment> {

    @Embedded
    private MaterialSerialNumber materialSerialNumber;

    @Embedded
    private Model model;

    @ManyToOne
    @JoinColumn(name = "equipmentType_id")
    private EquipmentType equipmentType;

    /**
     * Default constructor.
     * This constructor is empty because it is used by the JPA provider and the reflection API.
     */

    public Equipment() {
    }

    public Equipment(MaterialSerialNumber materialSerialNumber, Model model, EquipmentType equipmentType) {
        this.materialSerialNumber = MaterialSerialNumber.generate();
        this.model = model;
        this.equipmentType = equipmentType;
    }

    /**
     * Constructor.
     * <p>
     *     Constructor of the Equipment class.
     *     It receives the command and equipment type as parameters.
     *     It initializes the material serial number, model and equipment type attributes.
     * </p>
     * @param command The command to create an equipment
     * @param equipmentType The equipment type
     */

    public Equipment(CreateEquipmentCommand command, EquipmentType equipmentType) {
        this.materialSerialNumber = MaterialSerialNumber.generate();
        this.model = new Model(command.model());
        this.equipmentType = equipmentType;
    }

    /**
     * Getters
     * <p>
     *     Getters of the Equipment class.
     *     They return the material serial number, model and equipment type.
     *     They are used by the EquipmentQueryServiceImpl class.
     * </p>
     */

    //getters
    public String getMaterialSerialNumber() {
        return materialSerialNumber.materialSerialNumber();
    }

    public String getModel() {
        return model.model();
    }

    public String getEquipmentTypeName() {
        return equipmentType.getType().toString();
    }

}
