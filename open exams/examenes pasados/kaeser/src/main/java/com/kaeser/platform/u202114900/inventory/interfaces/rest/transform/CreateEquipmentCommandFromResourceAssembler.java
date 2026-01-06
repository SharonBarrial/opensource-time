package com.kaeser.platform.u202114900.inventory.interfaces.rest.transform;

import com.kaeser.platform.u202114900.inventory.domain.model.commands.CreateEquipmentCommand;
import com.kaeser.platform.u202114900.inventory.interfaces.rest.resources.CreateEquipmentResource;

/**
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */
public class CreateEquipmentCommandFromResourceAssembler {
    public static CreateEquipmentCommand toCommandFromResource(CreateEquipmentResource resource) {
        return new CreateEquipmentCommand(
                resource.model(),
                resource.equipmentTypeName());
    }
}
