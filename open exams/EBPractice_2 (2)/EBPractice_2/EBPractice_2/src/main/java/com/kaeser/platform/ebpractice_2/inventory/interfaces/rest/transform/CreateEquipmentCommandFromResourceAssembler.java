package com.kaeser.platform.ebpractice_2.inventory.interfaces.rest.transform;
import com.kaeser.platform.ebpractice_2.inventory.domain.model.commands.CreateEquipmentCommand;
import com.kaeser.platform.ebpractice_2.inventory.interfaces.rest.resources.CreateEquipmentResource;

/**
 * CreateEquipmentCommandFromResourceAssembler - Assembler to create a command from a resource.
 *
 * @author Fiorella Jarama Peñaloza
 */
public class CreateEquipmentCommandFromResourceAssembler {
    public static CreateEquipmentCommand toCommandFromResource(CreateEquipmentResource resource) {
        return new CreateEquipmentCommand(
                resource.model(),
                resource.equipmentTypeName());
    }
}
