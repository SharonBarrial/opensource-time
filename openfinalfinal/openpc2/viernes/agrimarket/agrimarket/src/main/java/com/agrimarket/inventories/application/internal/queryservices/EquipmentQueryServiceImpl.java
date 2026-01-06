package com.agrimarket.inventories.application.internal.queryservices;

import com.agrimarket.inventories.domain.model.aggregates.Equipment;
import com.agrimarket.inventories.domain.model.queries.GetEquipmentByIdQuery;
import com.agrimarket.inventories.domain.services.EquipmentQueryService;
import com.agrimarket.inventories.infrastructure.persistance.jpa.repositories.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

//Service that handles the query of getting an equipment by its id.
@Service
public class EquipmentQueryServiceImpl implements EquipmentQueryService {
    private final EquipmentRepository equipmentRepository;

    public EquipmentQueryServiceImpl(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public Optional<Equipment> handle(GetEquipmentByIdQuery query) {
        return this.equipmentRepository.findById(query.equipmentId());
    }
}
