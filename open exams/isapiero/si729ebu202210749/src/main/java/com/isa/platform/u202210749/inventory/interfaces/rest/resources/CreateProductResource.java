package com.isa.platform.u202210749.inventory.interfaces.rest.resources;

public record CreateProductResource(String brand, String model, String serialNumber, Long monitoringLevelId) {
}
