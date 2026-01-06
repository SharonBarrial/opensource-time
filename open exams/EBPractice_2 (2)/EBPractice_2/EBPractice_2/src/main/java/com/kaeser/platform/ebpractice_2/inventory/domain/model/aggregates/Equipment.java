package com.kaeser.platform.ebpractice_2.inventory.domain.model.aggregates;

import com.kaeser.platform.ebpractice_2.inventory.domain.model.commands.CreateEquipmentCommand;
import com.kaeser.platform.ebpractice_2.inventory.domain.model.valueobjects.MaterialSerialNumber;
import com.kaeser.platform.ebpractice_2.inventory.domain.model.valueobjects.Model;
import com.kaeser.platform.ebpractice_2.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.kaeser.platform.ebpractice_2.shared.domain.model.entities.EquipmentType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


/**
 * Equipment - Represents the equipment in the inventory.
 * @author Fiorella Jarama Peñaloza
 */

@Getter
@Setter
@Entity
public class



Equipment extends AuditableAbstractAggregateRoot<Equipment> {

    @Embedded
    private MaterialSerialNumber materialSerialNumber;

    @Embedded
    private Model model;

    @ManyToOne
    @JoinColumn(name = "equipmentType_id")
    private EquipmentType equipmentType;

    public Equipment() {
    }

    public Equipment(MaterialSerialNumber materialSerialNumber, Model model, EquipmentType equipmentType) {
        this.materialSerialNumber = MaterialSerialNumber.generate();
        this.model = model;
        this.equipmentType = equipmentType;
    }

    public Equipment(CreateEquipmentCommand command, EquipmentType equipmentType) {
        this.materialSerialNumber = MaterialSerialNumber.generate();
        this.model = new Model(command.model());
        this.equipmentType = equipmentType;
    }

    //getters
    public String getMaterialSerialNumber() {
        return materialSerialNumber.materialSerialNumber();
    }

    public String getModel() {
        return model.model();
    }

    public String getEquipmentTypeName() {
        return equipmentType.getType().name();
    }

}
