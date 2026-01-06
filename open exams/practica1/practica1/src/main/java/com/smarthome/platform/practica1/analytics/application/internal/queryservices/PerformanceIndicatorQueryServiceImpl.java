package com.smarthome.platform.practica1.analytics.application.internal.queryservices;

import com.smarthome.platform.practica1.analytics.domain.model.aggregates.PerformanceIndicator;
import com.smarthome.platform.practica1.analytics.domain.model.queries.GetAllPerformanceIndicatorsQuery;
import com.smarthome.platform.practica1.analytics.domain.services.PerformanceIndicatorQueryService;
import com.smarthome.platform.practica1.analytics.infrastructure.persistence.jpa.repositories.PerformanceIndicatorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformanceIndicatorQueryServiceImpl implements PerformanceIndicatorQueryService {
    private final PerformanceIndicatorRepository performanceIndicatorRepository;

    public PerformanceIndicatorQueryServiceImpl(PerformanceIndicatorRepository performanceIndicatorRepository) {
        this.performanceIndicatorRepository = performanceIndicatorRepository;
    }

    @Override
    public List<PerformanceIndicator> handle(GetAllPerformanceIndicatorsQuery query) {
        return performanceIndicatorRepository.findAll();
    }
}
