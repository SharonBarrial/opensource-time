package com.kaeser.platform.ebpractice_2.analytics.application.internal.queryservices;/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */

import com.kaeser.platform.ebpractice_2.analytics.domain.model.aggregates.MeasurableIndicator;
import com.kaeser.platform.ebpractice_2.analytics.domain.model.queries.GetMeasurableIndicatorById;
import com.kaeser.platform.ebpractice_2.analytics.domain.services.MeasurableIndicatorQueryService;
import com.kaeser.platform.ebpractice_2.analytics.infrastructure.persistence.jpa.repositories.MeasurableIndicatorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * MeasurableIndicatorQueryServiceImpl - Implements the MeasurableIndicatorQueryService interface.
 *
 * @author Fiorella Jarama Peñaloza
 */
@Service
public class MeasurableIndicatorQueryServiceImpl implements MeasurableIndicatorQueryService {

    private final MeasurableIndicatorRepository measurableIndicatorRepository;

    public MeasurableIndicatorQueryServiceImpl(MeasurableIndicatorRepository measurableIndicatorRepository) {
        this.measurableIndicatorRepository = measurableIndicatorRepository;
    }

    @Override
    public Optional<MeasurableIndicator> handle(GetMeasurableIndicatorById query) {
        return this.measurableIndicatorRepository.findById(query.measurableIndicatorId());
    }
}
