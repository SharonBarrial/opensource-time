package com.kaeser.platform.ebpractice_2.analytics.application.internal.commandservices;

import com.kaeser.platform.ebpractice_2.analytics.domain.model.aggregates.MeasurableIndicator;
import com.kaeser.platform.ebpractice_2.analytics.domain.model.commands.CreateMeasurableIndicatorCommand;
import com.kaeser.platform.ebpractice_2.analytics.domain.model.valueobjects.Symbol;
import com.kaeser.platform.ebpractice_2.analytics.domain.services.MeasurableIndicatorCommandService;
import com.kaeser.platform.ebpractice_2.analytics.infrastructure.persistence.jpa.repositories.MeasurableIndicatorRepository;
import com.kaeser.platform.ebpractice_2.inventory.domain.exceptions.EquipmentTypeNotFoundException;
import com.kaeser.platform.ebpractice_2.shared.domain.model.entities.EquipmentType;
import com.kaeser.platform.ebpractice_2.shared.domain.model.valueObjects.EquipmentTypeName;
import com.kaeser.platform.ebpractice_2.shared.infrastructure.persistence.jpa.configuration.strategy.repository.EquipmentTypeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * MeasurableIndicatorCommandServiceImpl - Implements the MeasurableIndicatorCommandService interface.
 *
 * @author Fiorella Jarama Peñaloza
 */
@Service
public class MeasurableIndicatorCommandServiceImpl implements MeasurableIndicatorCommandService {

    private final MeasurableIndicatorRepository measurableIndicatorRepository;
    private final EquipmentTypeRepository equipmentTypeRepository;

    public MeasurableIndicatorCommandServiceImpl(MeasurableIndicatorRepository measurableIndicatorRepository, EquipmentTypeRepository equipmentTypeRepository) {
        this.measurableIndicatorRepository = measurableIndicatorRepository;
        this.equipmentTypeRepository = equipmentTypeRepository;
    }


    @Override
    public Long handle(CreateMeasurableIndicatorCommand command) {
        // Convert command's equipmentTypeName (String) to EquipmentTypeName
        EquipmentTypeName typeName;
        Symbol symbol = new Symbol(command.symbol());
        try {
            typeName = EquipmentTypeName.valueOf(command.equipmentTypeName());
        } catch (IllegalArgumentException e) {
            throw new EquipmentTypeNotFoundException(command.equipmentTypeName());
        }

        // Check if equipment type exists
        Optional<EquipmentType> optionalEquipmentType = equipmentTypeRepository.findByType(typeName);
        EquipmentType equipmentType = optionalEquipmentType.orElseThrow(() -> new EquipmentTypeNotFoundException(command.equipmentTypeName()));

        // Check if a MeasurableIndicator with the same symbol and equipmentType already exists
        boolean measurableIndicatorExists = measurableIndicatorRepository.existsBySymbolAndEquipmentType(symbol, equipmentType);
        if (measurableIndicatorExists) {
            throw new IllegalArgumentException("A Measurable Indicator with the same symbol already exists for this Equipment Type");
        }

        // Validate thresholdMaximum >= thresholdMinimum
        if (command.thresholdMaximum() < command.thresholdMinimum()) {
            throw new IllegalArgumentException("Threshold Maximum must be greater than or equal to Threshold Minimum");
        }

        // Create and save the measurableIndicator
        MeasurableIndicator measurableIndicator = new MeasurableIndicator(command, equipmentType);
        try {
            measurableIndicatorRepository.save(measurableIndicator);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error saving equipment", e);
        }
        return measurableIndicator.getId();
    }

}
