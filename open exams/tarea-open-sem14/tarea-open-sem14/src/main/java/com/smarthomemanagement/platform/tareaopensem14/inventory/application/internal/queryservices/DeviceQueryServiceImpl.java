package com.smarthomemanagement.platform.tareaopensem14.inventory.application.internal.queryservices;

import com.smarthomemanagement.platform.tareaopensem14.inventory.domain.model.aggregates.Device;
import com.smarthomemanagement.platform.tareaopensem14.inventory.domain.model.queries.GetDeviceByIdQuery;
import com.smarthomemanagement.platform.tareaopensem14.inventory.domain.services.DeviceQueryService;
import com.smarthomemanagement.platform.tareaopensem14.inventory.infrastructure.persistence.jpa.repositories.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */

@Service
public class DeviceQueryServiceImpl implements DeviceQueryService {
    private final DeviceRepository deviceRepository;

    public DeviceQueryServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public Optional<Device> handle(GetDeviceByIdQuery query) {
        return this.deviceRepository.findById(query.deviceId());
    }
}
