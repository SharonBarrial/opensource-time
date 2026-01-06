package com.smarthome.platform.practica1.inventory.interfaces.rest.resources;

import java.util.Date;

public record UpdateDeviceResource(
        String serialNumber,
        String model,
        String deviceType,
        Date installationDate,
        String status) {}