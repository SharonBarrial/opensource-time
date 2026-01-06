package com.agrimarket.inventories.domain.services;

import com.agrimarket.inventories.domain.model.commands.CreateEquipmentCommand;
import com.agrimarket.inventories.domain.model.commands.SeedCategoryTypeCommand;

public interface CategoryTypeCommandService {
    Long handle(SeedCategoryTypeCommand command);
}
