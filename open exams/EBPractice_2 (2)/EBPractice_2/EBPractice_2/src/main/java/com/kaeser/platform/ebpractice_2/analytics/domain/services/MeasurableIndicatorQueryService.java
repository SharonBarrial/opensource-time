package com.kaeser.platform.ebpractice_2.analytics.domain.services;

import com.kaeser.platform.ebpractice_2.analytics.domain.model.aggregates.MeasurableIndicator;
import com.kaeser.platform.ebpractice_2.analytics.domain.model.queries.GetMeasurableIndicatorById;

import java.util.Optional;

/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
public interface MeasurableIndicatorQueryService {
    Optional<MeasurableIndicator> handle(GetMeasurableIndicatorById query);
}
