package com.smarthome.platform.practica1.inventory.domain.services;

import com.smarthome.platform.practica1.inventory.domain.model.aggregates.Device;
import com.smarthome.platform.practica1.inventory.domain.model.queries.GetAllDevicesQuery;

import java.util.List;

public interface DeviceQueryService {
    List<Device> handle(GetAllDevicesQuery query);
}
