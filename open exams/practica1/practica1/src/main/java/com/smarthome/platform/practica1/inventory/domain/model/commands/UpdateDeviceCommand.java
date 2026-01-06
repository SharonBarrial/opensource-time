package com.smarthome.platform.practica1.inventory.domain.model.commands;

import java.util.Date;

public record UpdateDeviceCommand(
        Long id,
        String serialNumber,
        String model,
        String deviceType,
        Date installationDate,
        String status) {}