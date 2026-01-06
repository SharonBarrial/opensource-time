package com.kaeser.platform.u202114900.shared.domain.model.entities;

import com.kaeser.platform.u202114900.shared.domain.model.valueobjects.EquipmentTypeName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

/**
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@With
public class EquipmentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EquipmentTypeName type;

    public EquipmentType(EquipmentTypeName type) {
        this.type = type;
    }
}










