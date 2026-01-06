package com.kaeser.platform.ebpractice_2.inventory.application.internal.queryservices;

import com.kaeser.platform.ebpractice_2.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.ebpractice_2.inventory.domain.model.queries.GetEquipmentById;
import com.kaeser.platform.ebpractice_2.inventory.domain.model.queries.GetEquipmentTypeByName;
import com.kaeser.platform.ebpractice_2.inventory.domain.services.EquipmentQueryService;
import com.kaeser.platform.ebpractice_2.inventory.infrastructure.persistence.jpa.repositories.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EquipmentQueryServiceImpl implements EquipmentQueryService {
    private final EquipmentRepository deviceRepository;

    public EquipmentQueryServiceImpl(EquipmentRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public Optional<Equipment> handle(GetEquipmentById query) {
        return this.deviceRepository.findById(query.equipmentId());
    }

    @Override
    public Optional<Equipment> handle(GetEquipmentTypeByName query) {
        return Optional.empty();
    }
}
