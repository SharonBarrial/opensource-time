package com.kaeser.platform.u202114900.shared.domain.services;

import com.kaeser.platform.u202114900.shared.domain.model.commands.SeedEquipmentTypeCommand;

/**
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */
public interface EquipmentTypeCommandService {
    Long handle(SeedEquipmentTypeCommand command);
}
