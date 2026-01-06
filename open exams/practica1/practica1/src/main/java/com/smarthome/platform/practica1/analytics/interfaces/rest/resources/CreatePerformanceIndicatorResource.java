package com.smarthome.platform.practica1.analytics.interfaces.rest.resources;

public record CreatePerformanceIndicatorResource(
        String name,
        String description,
        Double maxValue,
        Double minValue,
        String deviceType) {}
