package com.smarthome.platform.demo1.shared.domain.model.entities;

import com.smarthome.platform.demo1.shared.domain.model.valueobjects.DeviceTypeName;
import jakarta.persistence.*;
import lombok.*;

/**
 * DeviceType entity
 * <p>
 *     Represents the type of device.
 *     The types are: LIGHTING, HEATING, SECURITY.
 * </p>
 * @see DeviceTypeName
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
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

    /**
     * DeviceTypeName name.
     */

    @Enumerated(EnumType.STRING)
    private DeviceTypeName name;

    /**
     * Constructor.
     * @param name DeviceTypeName
     */

    public DeviceType(DeviceTypeName name) {
        this.name = name;
    }

}
