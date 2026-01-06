package com.smarthomemanagement.platform.tareaopensem14.shared.infrastructure.persistence.jpa.repositories;

import com.smarthomemanagement.platform.tareaopensem14.shared.domain.model.entities.DeviceType;
import com.smarthomemanagement.platform.tareaopensem14.shared.domain.model.valueobjects.DeviceTypeName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Vargas Revollé, Ariana - u20221928
 * @version 1.0
 */

@Repository
public interface DeviceTypeRepository extends JpaRepository<DeviceType, Long> {
    boolean existsByType(DeviceTypeName type);
}
