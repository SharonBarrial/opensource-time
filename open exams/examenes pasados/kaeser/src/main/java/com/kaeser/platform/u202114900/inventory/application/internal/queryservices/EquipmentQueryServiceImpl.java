package com.kaeser.platform.u202114900.inventory.application.internal.queryservices;

import com.kaeser.platform.u202114900.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.u202114900.inventory.domain.model.queries.GetEquipmentById;
import com.kaeser.platform.u202114900.inventory.domain.model.queries.GetEquipmentTypeByName;
import com.kaeser.platform.u202114900.inventory.domain.services.EquipmentQueryService;
import com.kaeser.platform.u202114900.inventory.infrastructure.persistance.jpa.repositories.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * EquipmentQueryServiceImpl class
 * <p>
 *     This class represents the service to handle the queries for the equipment.
 *     It implements the EquipmentQueryService interface.
 *     It contains the methods to handle the queries to get an equipment by its id and to get an equipment type by its name.
 * </p>
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */

@Service
public class EquipmentQueryServiceImpl implements EquipmentQueryService {
    private final EquipmentRepository deviceRepository;

    /**
     * Constructor
     * <p>
     *     Constructor of the EquipmentQueryServiceImpl class.
     *     It receives the deviceRepository as a parameter.
     *     It initializes the deviceRepository attribute.
     * </p>
     * @param deviceRepository The equipment repository
     */

    public EquipmentQueryServiceImpl(EquipmentRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    /**
     * Method to handle the query to get an equipment by its id.
     * <p>
     *     This method receives a GetEquipmentById query and returns an Optional of Equipment.
     *     It gets the equipment by its id from the deviceRepository.
     * </p>
     * @param query The GetEquipmentById query
     * @return An Optional of Equipment
     */

    @Override
    public Optional<Equipment> handle(GetEquipmentById query) {
        return this.deviceRepository.findById(query.equipmentId());
    }

    /**
     * Method to handle the query to get an equipment type by its name.
     * <p>
     *     This method receives a GetEquipmentTypeByName query and returns an Optional of Equipment.
     *     It gets the equipment type by its name from the deviceRepository.
     * </p>
     * @param query The GetEquipmentTypeByName query
     * @return An Optional of Equipment
     */

    @Override
    public Optional<Equipment> handle(GetEquipmentTypeByName query) {
        return Optional.empty();
    }
}
