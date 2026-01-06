package com.kaeser.platform.ebpractice_2.inventory.application.internal.commandservices;

import com.kaeser.platform.ebpractice_2.inventory.domain.exceptions.EquipmentTypeNotFoundException;
import com.kaeser.platform.ebpractice_2.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.ebpractice_2.inventory.domain.model.commands.CreateEquipmentCommand;
import com.kaeser.platform.ebpractice_2.inventory.domain.services.EquipmentCommandService;
import com.kaeser.platform.ebpractice_2.inventory.infrastructure.persistence.jpa.repositories.EquipmentRepository;
import com.kaeser.platform.ebpractice_2.shared.domain.model.entities.EquipmentType;
import com.kaeser.platform.ebpractice_2.shared.domain.model.valueObjects.EquipmentTypeName;
import com.kaeser.platform.ebpractice_2.shared.infrastructure.persistence.jpa.configuration.strategy.repository.EquipmentTypeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EquipmentCommandServiceImpl implements EquipmentCommandService {

    private final EquipmentRepository equipmentRepository;
    private final EquipmentTypeRepository equipmentTypeRepository;

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
