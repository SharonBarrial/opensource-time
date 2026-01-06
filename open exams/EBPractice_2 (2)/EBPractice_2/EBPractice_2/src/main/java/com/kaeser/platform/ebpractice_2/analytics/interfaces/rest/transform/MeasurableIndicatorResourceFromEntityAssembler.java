package com.kaeser.platform.ebpractice_2.analytics.interfaces.rest.transform;
import com.kaeser.platform.ebpractice_2.analytics.domain.model.aggregates.MeasurableIndicator;
import com.kaeser.platform.ebpractice_2.analytics.interfaces.rest.resources.MeasurableIndicatorResource;

/**
 * MeasurableIndicatorResourceFromEntityAssembler - Assembler to create a resource from an entity.
 *
 * @author Fiorella Jarama Peñaloza
 */
public class MeasurableIndicatorResourceFromEntityAssembler {
    public static MeasurableIndicatorResource toResourceFromEntity(MeasurableIndicator entity) {
        return new MeasurableIndicatorResource(
                entity.getId(),
                entity.getSymbol(),
                entity.getDescription(),
                entity.getThresholdMaximum(),
                entity.getThresholdMinimum(),
                entity.getEquipmentTypeName()
        );
    }

}
