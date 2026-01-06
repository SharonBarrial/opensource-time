package com.kaeser.platform.u202114900.analytics.application.internal.queryservices;

import com.kaeser.platform.u202114900.analytics.domain.model.aggregates.MeasurableIndicator;
import com.kaeser.platform.u202114900.analytics.domain.model.queries.GetMeasurableIndicatorById;
import com.kaeser.platform.u202114900.analytics.domain.services.MeasurableIndicatorQueryService;
import com.kaeser.platform.u202114900.analytics.infrastructure.persistance.jpa.repositories.MeasurableIndicatorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * MeasurableIndicatorQueryServiceImpl
 * This class represents the implementation of the MeasurableIndicatorQueryService interface.
 * It is used to handle the query to get a MeasurableIndicator by its id.
 * It uses the MeasurableIndicatorRepository to get the MeasurableIndicator.
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */

@Service
public class MeasurableIndicatorQueryServiceImpl implements MeasurableIndicatorQueryService {

    private final MeasurableIndicatorRepository measurableIndicatorRepository;

    public MeasurableIndicatorQueryServiceImpl(MeasurableIndicatorRepository measurableIndicatorRepository) {
        this.measurableIndicatorRepository = measurableIndicatorRepository;
    }

    /**
     * Method to handle the GetMeasurableIndicatorById query.
     * @param query GetMeasurableIndicatorById query
     * @return Optional<MeasurableIndicator> MeasurableIndicator
     */

    @Override
    public Optional<MeasurableIndicator> handle(GetMeasurableIndicatorById query) {
        return this.measurableIndicatorRepository.findById(query.measurableIndicatorId());
    }
}
