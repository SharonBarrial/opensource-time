package com.kaeser.platform.u202114900.analytics.application.internal.commandservices;

import com.kaeser.platform.u202114900.analytics.domain.model.aggregates.MeasurableIndicator;
import com.kaeser.platform.u202114900.analytics.domain.model.commands.CreateMeasurableIndicatorCommand;
import com.kaeser.platform.u202114900.analytics.domain.model.valueobjects.Symbol;
import com.kaeser.platform.u202114900.analytics.domain.services.MeasurableIndicatorCommandService;
import com.kaeser.platform.u202114900.analytics.infrastructure.persistance.jpa.repositories.MeasurableIndicatorRepository;
import com.kaeser.platform.u202114900.inventory.domain.exceptions.EquipmentTypeNotFoundException;
import com.kaeser.platform.u202114900.shared.domain.model.entities.EquipmentType;
import com.kaeser.platform.u202114900.shared.domain.model.valueobjects.EquipmentTypeName;
import com.kaeser.platform.u202114900.shared.infrastructure.persistence.jpa.configuration.strategy.repositories.EquipmentTypeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of the MeasurableIndicatorCommandService interface.
 * <p>
 *      This class is responsible for handling the CreateMeasurableIndicatorCommand command.
 * </p>
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */

@Service
public class MeasurableIndicatorCommandServiceImpl implements MeasurableIndicatorCommandService {

    /**
     * MeasurableIndicatorRepository instance
     * @see MeasurableIndicatorRepository
     */

    private final MeasurableIndicatorRepository measurableIndicatorRepository;
    private final EquipmentTypeRepository equipmentTypeRepository;

    /**
     * Constructor
     * @see MeasurableIndicatorCommandServiceImpl
     * @param measurableIndicatorRepository MeasurableIndicatorRepository instance
     * @param equipmentTypeRepository EquipmentTypeRepository instance
     */
    public MeasurableIndicatorCommandServiceImpl(MeasurableIndicatorRepository measurableIndicatorRepository, EquipmentTypeRepository equipmentTypeRepository) {
        this.measurableIndicatorRepository = measurableIndicatorRepository;
        this.equipmentTypeRepository = equipmentTypeRepository;
    }

    /**
     * Method to handle the CreateMeasurableIndicatorCommand command.
     * <p>
     *      This method is responsible for handling the CreateMeasurableIndicatorCommand command.
     *      It converts the command's equipmentTypeName (String) to EquipmentTypeName and checks if the equipment type exists.
     *      It also checks if a MeasurableIndicator with the same symbol and equipmentType already exists.
     *      It validates that thresholdMaximum >= thresholdMinimum.
     *      Finally, it creates and saves the measurableIndicator.
     *      If an error occurs, it throws an IllegalArgumentException.
     *      If the equipment type does not exist, it throws an EquipmentTypeNotFoundException.
     *      If the thresholdMaximum is less than the thresholdMinimum, it throws an IllegalArgumentException.
     *      If a MeasurableIndicator with the same symbol and equipmentType already exists, it throws an IllegalArgumentException.
     *      If an error occurs saving the equipment, it throws an IllegalArgumentException.
     *      Otherwise, it returns the measurableIndicator's id.
     *      @see CreateMeasurableIndicatorCommand
     * </p>
     * @param command CreateMeasurableIndicatorCommand command
     * @return Long
     */

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
