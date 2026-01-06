package com.agrimarket.inventories.domain.services;

import com.agrimarket.inventories.domain.model.commands.CreateEquipmentCommand;

/**
 * Service to handle Equipment commands
 * @version 1.0
 * @author Sharon Antuanet Ivet Barrial Marin
 */
public interface EquipmentCommandService {
    Long handle(CreateEquipmentCommand command);
}
