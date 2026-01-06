package com.kaeser.platform.ebpractice_2.shared.domain.model.entities;

import com.kaeser.platform.ebpractice_2.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.kaeser.platform.ebpractice_2.shared.domain.model.valueObjects.EquipmentTypeName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

/**
 * EquipmentType - Represents the type of equipment.
 *
 * @author Fiorella Jarama Peñaloza
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@With
public class EquipmentType{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EquipmentTypeName type;

    public EquipmentType(EquipmentTypeName type) {
        this.type = type;
    }

}
