package com.isa.platform.u20221b127.inventory.domain.model.commands;

public record CreateProductCommand(String brand, String model, String serialNumber, String monitoringLevel) {
}
