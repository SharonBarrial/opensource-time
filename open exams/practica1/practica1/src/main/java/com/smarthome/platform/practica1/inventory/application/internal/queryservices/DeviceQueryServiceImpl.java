package com.smarthome.platform.practica1.inventory.application.internal.queryservices;

import com.smarthome.platform.practica1.inventory.domain.model.aggregates.Device;
import com.smarthome.platform.practica1.inventory.domain.model.queries.GetAllDevicesQuery;
import com.smarthome.platform.practica1.inventory.domain.services.DeviceQueryService;
import com.smarthome.platform.practica1.inventory.infrastructure.persistence.jpa.repositories.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceQueryServiceImpl implements DeviceQueryService {
    private final DeviceRepository deviceRepository;

    public DeviceQueryServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public List<Device> handle(GetAllDevicesQuery query) {
        return deviceRepository.findAll();
    }
}
