package com.kaeser.platform.u202114900.shared.application.internal.commandservices;

import com.kaeser.platform.u202114900.shared.domain.model.commands.SeedEquipmentTypeCommand;
import com.kaeser.platform.u202114900.shared.domain.model.entities.EquipmentType;
import com.kaeser.platform.u202114900.shared.domain.model.valueobjects.EquipmentTypeName;
import com.kaeser.platform.u202114900.shared.domain.services.EquipmentTypeCommandService;
import com.kaeser.platform.u202114900.shared.infrastructure.persistence.jpa.configuration.strategy.repositories.EquipmentTypeRepository;
import org.springframework.stereotype.Service;

/**
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */

@Service
public class EquipmentTypeCommandServiceImpl implements EquipmentTypeCommandService {

    private final EquipmentTypeRepository equipmentTypeRepository;

    public EquipmentTypeCommandServiceImpl(EquipmentTypeRepository equipmentTypeRepository) {
        this.equipmentTypeRepository = equipmentTypeRepository;
    }

    @Override
    public Long handle(SeedEquipmentTypeCommand command) {
        EquipmentTypeName[] equipmentTypeNames = EquipmentTypeName.values();
        Long lastId = null;

        for (EquipmentTypeName equipmentTypeName : equipmentTypeNames) {
            if (!equipmentTypeRepository.existsByType(equipmentTypeName)) {
                var equipmentType = new EquipmentType(equipmentTypeName);
                equipmentTypeRepository.save(equipmentType);
                lastId = equipmentType.getId();
            }
        }
        return lastId;
    }
}
