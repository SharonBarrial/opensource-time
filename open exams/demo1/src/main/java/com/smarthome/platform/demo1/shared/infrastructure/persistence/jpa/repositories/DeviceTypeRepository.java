package com.smarthome.platform.demo1.shared.infrastructure.persistence.jpa.repositories;

import com.smarthome.platform.demo1.shared.domain.model.entities.DeviceType;
import com.smarthome.platform.demo1.shared.domain.model.valueobjects.DeviceTypeName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * DeviceTypeRepository interface
 * <p>
 *     This interface is used to manage the device types in the database.
 *     It extends the JpaRepository interface from Spring Data JPA to manage the device types.
 *     It provides methods to check if a device type exists by name and to find a device type by name.
 * </p>
 * @see JpaRepository
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */

@Repository
public interface DeviceTypeRepository extends JpaRepository<DeviceType, Long> {

    boolean existsByName(DeviceTypeName name);
    Optional<DeviceType> findByName(DeviceTypeName type);
}
