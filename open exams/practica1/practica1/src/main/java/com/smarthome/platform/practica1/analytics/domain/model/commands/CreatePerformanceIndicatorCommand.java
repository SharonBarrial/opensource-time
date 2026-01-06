package com.smarthome.platform.practica1.analytics.domain.model.commands;

public record CreatePerformanceIndicatorCommand(
        String name,
        String description,
        Double minValue,
        Double maxValue,
        String deviceType) {}