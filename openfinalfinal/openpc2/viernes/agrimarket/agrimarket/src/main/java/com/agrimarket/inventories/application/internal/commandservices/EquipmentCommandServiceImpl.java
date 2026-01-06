package com.agrimarket.inventories.application.internal.commandservices;

import com.agrimarket.inventories.domain.model.aggregates.Equipment;
import com.agrimarket.inventories.domain.model.commands.CreateEquipmentCommand;
import com.agrimarket.inventories.domain.model.valueobjects.Name;
import com.agrimarket.inventories.domain.services.EquipmentCommandService;
import com.agrimarket.inventories.infrastructure.persistance.jpa.repositories.CategoryTypeRepository;
import com.agrimarket.inventories.infrastructure.persistance.jpa.repositories.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service to handle equipment commands
 * @version 1.0
 *
 */
@Service
public class EquipmentCommandServiceImpl implements EquipmentCommandService {

    private final EquipmentRepository equipmentRepository;
    private final CategoryTypeRepository categoryTypeRepository;

    public EquipmentCommandServiceImpl(EquipmentRepository equipmentRepository, CategoryTypeRepository categoryTypeRepository) {
        this.equipmentRepository = equipmentRepository;
        this.categoryTypeRepository = categoryTypeRepository;
    }

    /**
     * Handle the command to seed equipment types
     * @param command Command containing the details for seeding equipment types
     * @return ID of the last created equipment type
     * @author Sharon Antuanet Ivet Barrial Marin
     */

    @Override
    public Long handle(CreateEquipmentCommand command) {
        var categoryType = categoryTypeRepository.findById(command.categoryId());
        if(categoryType.isEmpty()) {
            throw new IllegalArgumentException("Category type not found");
        }

        Name name = new Name(command.name());
        if(equipmentRepository.existsByName(name)) {
            throw new IllegalArgumentException("Equipment with same name");
        }

        var equipment = new Equipment(command, categoryType.get());
        try {
            equipmentRepository.save(equipment);
        } catch (Exception e) {
            throw new RuntimeException("Error while saving sensor: " + e.getMessage());
        }
        return equipment.getId();
    }
}
