package com.kaeser.platform.ebpractice_2.analytics.interfaces.rest.transform;

import com.kaeser.platform.ebpractice_2.analytics.domain.model.commands.CreateMeasurableIndicatorCommand;
import com.kaeser.platform.ebpractice_2.analytics.interfaces.rest.resources.CreateMeasurableIndicatorResource;

/**
 * CreateMeasurableIndicatorCommandFromResourceAssembler - Assembler to create a command from a resource.
 *
 * @author Fiorella Jarama Peñaloza
 */
public class CreateMeasurableIndicatorCommandFromResourceAssembler {
    public static CreateMeasurableIndicatorCommand toCommandFromResource(CreateMeasurableIndicatorResource resource) {
        return new CreateMeasurableIndicatorCommand(
                resource.symbol(),
                resource.description(),
                resource.thresholdMaximum(),
                resource.thresholdMinimum(),
                resource.equipmentTypeName());
    }
}
