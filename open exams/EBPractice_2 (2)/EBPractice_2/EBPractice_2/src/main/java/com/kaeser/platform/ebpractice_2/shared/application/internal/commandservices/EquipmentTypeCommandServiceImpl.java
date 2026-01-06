package com.kaeser.platform.ebpractice_2.shared.application.internal.commandservices;

import com.kaeser.platform.ebpractice_2.shared.domain.model.commands.SeedEquipmentTypeCommmand;
import com.kaeser.platform.ebpractice_2.shared.domain.model.entities.EquipmentType;
import com.kaeser.platform.ebpractice_2.shared.domain.model.valueObjects.EquipmentTypeName;
import com.kaeser.platform.ebpractice_2.shared.domain.services.EquipmentTypeCommandService;
import com.kaeser.platform.ebpractice_2.shared.infrastructure.persistence.jpa.configuration.strategy.repository.EquipmentTypeRepository;
import org.springframework.stereotype.Service;

/**
 * Descripción de la clase.
 *
 * @author Fiorella Jarama Peñaloza
 */

@Service
public class EquipmentTypeCommandServiceImpl implements EquipmentTypeCommandService {

    private final EquipmentTypeRepository equipmentTypeRepository;

    public EquipmentTypeCommandServiceImpl(EquipmentTypeRepository deviceTypeRepository) {
        this.equipmentTypeRepository = deviceTypeRepository;
    }

    @Override
    public Long handle(SeedEquipmentTypeCommmand command) {
        EquipmentTypeName[] deviceTypeNames = EquipmentTypeName.values();
        Long lastId = null;

        for (EquipmentTypeName equipmentTypeName : deviceTypeNames) {
            if (!equipmentTypeRepository.existsByType(equipmentTypeName)) {
                var deviceType = new EquipmentType(equipmentTypeName);
                equipmentTypeRepository.save(deviceType);
                lastId = deviceType.getId();
            }
        }
        return lastId;
    }
}
