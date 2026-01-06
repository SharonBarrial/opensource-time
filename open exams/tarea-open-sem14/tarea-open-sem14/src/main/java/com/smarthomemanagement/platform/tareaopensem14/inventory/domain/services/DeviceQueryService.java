package com.smarthomemanagement.platform.tareaopensem14.inventory.domain.services;

import com.smarthomemanagement.platform.tareaopensem14.inventory.domain.model.aggregates.Device;
import com.smarthomemanagement.platform.tareaopensem14.inventory.domain.model.queries.GetDeviceByIdQuery;

import java.util.Optional;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */
public interface DeviceQueryService {
    Optional<Device> handle(GetDeviceByIdQuery query);
}
