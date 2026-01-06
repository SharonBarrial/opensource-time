package com.kaeser.platform.ebpractice_2.shared.domain.services;

import com.kaeser.platform.ebpractice_2.shared.domain.model.commands.SeedEquipmentTypeCommmand;

/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
public interface EquipmentTypeCommandService {
    Long handle(SeedEquipmentTypeCommmand command);
}
