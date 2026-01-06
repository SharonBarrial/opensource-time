package com.kaeser.platform.ebpractice_2.inventory.domain.services;

import com.kaeser.platform.ebpractice_2.inventory.domain.model.commands.CreateEquipmentCommand;

/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */

public interface EquipmentCommandService {
    Long handle(CreateEquipmentCommand command);
}
