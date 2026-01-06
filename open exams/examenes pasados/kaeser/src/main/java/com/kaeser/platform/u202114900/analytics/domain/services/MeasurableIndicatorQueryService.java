package com.kaeser.platform.u202114900.analytics.domain.services;

import com.kaeser.platform.u202114900.analytics.domain.model.aggregates.MeasurableIndicator;
import com.kaeser.platform.u202114900.analytics.domain.model.commands.CreateMeasurableIndicatorCommand;
import com.kaeser.platform.u202114900.analytics.domain.model.queries.GetMeasurableIndicatorById;

import java.util.Optional;

/**
 * Interface for the MeasurableIndicatorQueryService
 * <p>
 *     This interface represents the service to handle the queries for the measurable indicators.
 *     It contains the method to handle the query to get a measurable indicator by its id.
 *     It is implemented by the MeasurableIndicatorQueryServiceImpl class.
 * </p>
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */
public interface MeasurableIndicatorQueryService {
    Optional<MeasurableIndicator> handle(GetMeasurableIndicatorById query);
}
