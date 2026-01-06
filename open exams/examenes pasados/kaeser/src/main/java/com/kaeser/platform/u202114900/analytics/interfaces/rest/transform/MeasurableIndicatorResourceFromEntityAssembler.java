package com.kaeser.platform.u202114900.analytics.interfaces.rest.transform;

import com.kaeser.platform.u202114900.analytics.domain.model.aggregates.MeasurableIndicator;
import com.kaeser.platform.u202114900.analytics.interfaces.rest.resources.MeasurableIndicatorResource;

/**
 * MeasurableIndicatorResourceFromEntityAssembler class
 * <p>
 *     This class represents the assembler to create a measurable indicator resource from an entity.
 *     It contains the method to create a measurable indicator resource from an entity.
 *     It is used by the MeasurableIndicatorQueryController class.
 * </p>
 * @see MeasurableIndicatorResource
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */
public class MeasurableIndicatorResourceFromEntityAssembler {
    public static MeasurableIndicatorResource toResourceFromEntity(MeasurableIndicator measurableIndicator){
        return new MeasurableIndicatorResource(
                measurableIndicator.getId(),
                measurableIndicator.getSymbol(),
                measurableIndicator.getDescription(),
                measurableIndicator.getThresholdMaximum(),
                measurableIndicator.getThresholdMinimum(),
                measurableIndicator.getEquipmentTypeName()
        );
    }
}
