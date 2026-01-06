package com.kaeser.platform.ebpractice_2.inventory.interfaces.rest.transform;/**
 * @author Fiorella Jarama Peñaloza
 * @version 2.0
 */

import com.kaeser.platform.ebpractice_2.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.ebpractice_2.inventory.interfaces.rest.resources.EquipmentResource;

/**
 * Descripción de la clase.
 *
 * @author Fiorella Jarama Peñaloza
 */
public class EquipmentResourceFromEntityAssembler {
    public static EquipmentResource toResourceFromEntity(Equipment entity) {
        return new EquipmentResource(
                entity.getId(),
                entity.getMaterialSerialNumber(),
                entity.getModel(),
                entity.getEquipmentTypeName()
        );
    }
}
