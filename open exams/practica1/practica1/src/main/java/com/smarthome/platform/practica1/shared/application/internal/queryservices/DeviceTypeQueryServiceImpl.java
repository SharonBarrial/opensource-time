package com.smarthome.platform.practica1.shared.application.internal.queryservices;

import com.smarthome.platform.practica1.shared.domain.model.entities.DeviceType;
import com.smarthome.platform.practica1.shared.domain.model.queries.GetAllDeviceTypesQuery;
import com.smarthome.platform.practica1.shared.domain.services.DeviceTypeQueryService;
import com.smarthome.platform.practica1.shared.infrastructure.persistence.jpa.repositories.DeviceTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceTypeQueryServiceImpl implements DeviceTypeQueryService {
    private final DeviceTypeRepository deviceTypeRepository;

    public DeviceTypeQueryServiceImpl(DeviceTypeRepository deviceTypeRepository) {
        this.deviceTypeRepository = deviceTypeRepository;
    }

    @Override
    public List<DeviceType> handle(GetAllDeviceTypesQuery query) {
        return deviceTypeRepository.findAll();
    }
}
