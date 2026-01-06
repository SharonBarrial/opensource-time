package com.agrimarket.inventories.interfaces.rest.transform;

import com.agrimarket.inventories.domain.model.commands.CreateEquipmentCommand;
import com.agrimarket.inventories.interfaces.rest.resource.CreateEquipmentResource;
import com.agrimarket.inventories.interfaces.rest.resource.EquipmentResource;

public class CreateEquipmentCommandFromResourceAssembler {
    public static CreateEquipmentCommand toCommandFromResource(CreateEquipmentResource equipmentResource) {
        return new CreateEquipmentCommand(
                equipmentResource.name(),
                equipmentResource.categoryId(),
                equipmentResource.description(),
                equipmentResource.referenceImageUrl()
        );
    }
}
