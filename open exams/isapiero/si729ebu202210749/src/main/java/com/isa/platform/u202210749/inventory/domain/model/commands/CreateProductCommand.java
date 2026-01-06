package com.isa.platform.u202210749.inventory.domain.model.commands;

public record CreateProductCommand(String brand, String model, String serialNumber, Long monitoringLevelId) {
}
