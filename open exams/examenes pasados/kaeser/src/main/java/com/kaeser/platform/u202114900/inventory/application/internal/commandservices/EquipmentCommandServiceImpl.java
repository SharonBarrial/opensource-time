package com.kaeser.platform.u202114900.inventory.application.internal.commandservices;

import com.kaeser.platform.u202114900.inventory.domain.exceptions.EquipmentTypeNotFoundException;
import com.kaeser.platform.u202114900.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.u202114900.inventory.domain.model.commands.CreateEquipmentCommand;
import com.kaeser.platform.u202114900.inventory.domain.services.EquipmentCommandService;
import com.kaeser.platform.u202114900.inventory.infrastructure.persistance.jpa.repositories.EquipmentRepository;
import com.kaeser.platform.u202114900.shared.domain.model.entities.EquipmentType;
import com.kaeser.platform.u202114900.shared.domain.model.valueobjects.EquipmentTypeName;
import com.kaeser.platform.u202114900.shared.infrastructure.persistence.jpa.configuration.strategy.repositories.EquipmentTypeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * EquipmentCommandServiceImpl class
 * <p>
 *     This class represents the service to handle the commands for the equipment.
 *     It implements the EquipmentCommandService interface.
 *     It contains the method to handle the creation of an equipment.
 * </p>
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */
@Service
public class EquipmentCommandServiceImpl implements EquipmentCommandService {

    private final EquipmentRepository equipmentRepository;
    private final EquipmentTypeRepository equipmentTypeRepository;

    /**
     * Constructor
     * <p>
     *     Constructor of the EquipmentCommandServiceImpl class.
     *     It receives the equipmentRepository and equipmentTypeRepository as parameters.
     *     It initializes the equipmentRepository and equipmentTypeRepository attributes.
     * </p>
     * @param equipmentRepository The equipment repository
     * @param equipmentTypeRepository The equipment type repository
     */

    public EquipmentCommandServiceImpl(EquipmentRepository equipmentRepository, EquipmentTypeRepository equipmentTypeRepository) {
        this.equipmentRepository = equipmentRepository;
        this.equipmentTypeRepository = equipmentTypeRepository;
    }

    @Override
    public Long handle(CreateEquipmentCommand command) {
        // Convert command's equipmentTypeName (String) to EquipmentTypeName
        EquipmentTypeName typeName;
        try {
            typeName = EquipmentTypeName.valueOf(command.equipmentTypeName());
        } catch (IllegalArgumentException e) {
            throw new EquipmentTypeNotFoundException(command.equipmentTypeName());
        }

        // Check if equipment type exists
        Optional<EquipmentType> optionalEquipmentType = equipmentTypeRepository.findByType(typeName);
        EquipmentType equipmentType = optionalEquipmentType.orElseThrow(() -> new EquipmentTypeNotFoundException(command.equipmentTypeName()));

        // Create and save the equipment
        Equipment equipment = new Equipment(command, equipmentType);
        try {
            equipmentRepository.save(equipment);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error saving equipment", e);
        }
        return equipment.getId();
    }

}
