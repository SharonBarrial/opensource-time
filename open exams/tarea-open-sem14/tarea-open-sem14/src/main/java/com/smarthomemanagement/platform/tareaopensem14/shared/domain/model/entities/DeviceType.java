package com.smarthomemanagement.platform.tareaopensem14.shared.domain.model.entities;

import com.smarthomemanagement.platform.tareaopensem14.shared.domain.model.valueobjects.DeviceTypeName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

/**
 * @author Vargas Revollé, Ariana - u20221928
 * @version 1.0
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@With
public class DeviceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private DeviceTypeName type;

    public DeviceType(DeviceTypeName type) {
        this.type = type;
    }
}
