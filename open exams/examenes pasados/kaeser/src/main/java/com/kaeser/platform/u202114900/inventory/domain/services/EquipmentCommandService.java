package com.kaeser.platform.u202114900.inventory.domain.services;

import com.kaeser.platform.u202114900.inventory.domain.model.commands.CreateEquipmentCommand;

/**
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */
public interface EquipmentCommandService {
   Long handle(CreateEquipmentCommand command);
}
