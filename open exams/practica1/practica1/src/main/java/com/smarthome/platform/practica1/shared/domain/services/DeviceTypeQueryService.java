package com.smarthome.platform.practica1.shared.domain.services;

import com.smarthome.platform.practica1.shared.domain.model.entities.DeviceType;
import com.smarthome.platform.practica1.shared.domain.model.queries.GetAllDeviceTypesQuery;

import java.util.List;

public interface DeviceTypeQueryService {
    List<DeviceType> handle(GetAllDeviceTypesQuery query);
}