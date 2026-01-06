package com.smarthomemanagement.platform.tareaopensem14.inventory.infrastructure.persistence.jpa.repositories;

import com.smarthomemanagement.platform.tareaopensem14.inventory.domain.model.aggregates.Device;
import com.smarthomemanagement.platform.tareaopensem14.inventory.domain.model.valueobjects.SerialNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    boolean existsBySerialNumber(SerialNumber serialNumber);
}
