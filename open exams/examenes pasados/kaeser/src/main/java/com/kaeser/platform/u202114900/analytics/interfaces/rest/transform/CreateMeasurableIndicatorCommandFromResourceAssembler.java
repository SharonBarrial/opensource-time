package com.kaeser.platform.u202114900.analytics.interfaces.rest.transform;

import com.kaeser.platform.u202114900.analytics.domain.model.commands.CreateMeasurableIndicatorCommand;
import com.kaeser.platform.u202114900.analytics.interfaces.rest.resources.CreateMeasurableIndicatorResource;

import javax.swing.plaf.PanelUI;

/**
 * CreateMeasurableIndicatorCommandFromResourceAssembler class
 * <p>
 *     This class represents the assembler to create a measurable indicator command from a resource.
 *     It contains the method to create a measurable indicator command from a resource.
 *     It is used by the MeasurableIndicatorCommandController class.
 * </p>
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */
public class CreateMeasurableIndicatorCommandFromResourceAssembler {
    public static CreateMeasurableIndicatorCommand toCommandFromResource(CreateMeasurableIndicatorResource resource){
        return new CreateMeasurableIndicatorCommand(
                resource.symbol(),
                resource.description(),
                resource.thresholdMaximum(),
                resource.thresholdMinimum(),
                resource.equipmentTypeName()
        );
    }
}
