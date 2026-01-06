package com.smarthome.platform.practica1.analytics.domain.services;

import com.smarthome.platform.practica1.analytics.domain.model.aggregates.PerformanceIndicator;
import com.smarthome.platform.practica1.analytics.domain.model.queries.GetAllPerformanceIndicatorsQuery;

import java.util.List;

public interface PerformanceIndicatorQueryService {
    List<PerformanceIndicator> handle(GetAllPerformanceIndicatorsQuery query);
}
