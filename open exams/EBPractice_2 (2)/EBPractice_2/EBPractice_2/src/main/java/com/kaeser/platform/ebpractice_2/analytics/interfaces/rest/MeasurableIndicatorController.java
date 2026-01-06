package com.kaeser.platform.ebpractice_2.analytics.interfaces.rest;

import com.kaeser.platform.ebpractice_2.analytics.domain.model.queries.GetMeasurableIndicatorById;
import com.kaeser.platform.ebpractice_2.analytics.domain.services.MeasurableIndicatorCommandService;
import com.kaeser.platform.ebpractice_2.analytics.domain.services.MeasurableIndicatorQueryService;
import com.kaeser.platform.ebpractice_2.analytics.interfaces.rest.resources.CreateMeasurableIndicatorResource;
import com.kaeser.platform.ebpractice_2.analytics.interfaces.rest.resources.MeasurableIndicatorResource;
import com.kaeser.platform.ebpractice_2.analytics.interfaces.rest.transform.CreateMeasurableIndicatorCommandFromResourceAssembler;
import com.kaeser.platform.ebpractice_2.analytics.interfaces.rest.transform.MeasurableIndicatorResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class is the controller for the Measurable Indicator entity.
 *
 * @author Fiorella Jarama Peñaloza
 */
@RestController
@RequestMapping(value = "api/v1/measurable-indicators", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Measurable Indicators", description = "Measurable Indicators Management Endpoints")
public class MeasurableIndicatorController {

   private final MeasurableIndicatorCommandService measurableIndicatorCommandService;
   private final MeasurableIndicatorQueryService measurableIndicatorQueryService;

    public MeasurableIndicatorController(MeasurableIndicatorCommandService measurableIndicatorCommandService, MeasurableIndicatorQueryService measurableIndicatorQueryService) {
        this.measurableIndicatorCommandService = measurableIndicatorCommandService;
        this.measurableIndicatorQueryService = measurableIndicatorQueryService;
    }

    @PostMapping
    public ResponseEntity<MeasurableIndicatorResource> createDevice(@RequestBody CreateMeasurableIndicatorResource res) {
        var createMeasurableIndicatorCommand = CreateMeasurableIndicatorCommandFromResourceAssembler.toCommandFromResource(res);
        var measurableIndicatorId = measurableIndicatorCommandService.handle(createMeasurableIndicatorCommand);

        if (measurableIndicatorId == 0L) {
            return ResponseEntity.badRequest().build();
        }

        // Retrieve the created MeasurableIndicator including equipmentType as String
        var getMeasurableIndicatorByIdQuery = new GetMeasurableIndicatorById(measurableIndicatorId);
        var measurableIndicator = measurableIndicatorQueryService.handle(getMeasurableIndicatorByIdQuery);

        if (measurableIndicator.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        // Convert to MeasurableIndicatorResource including equipmentType as String
        var measurableIndicatorResource = MeasurableIndicatorResourceFromEntityAssembler.toResourceFromEntity(measurableIndicator.get());

        // Return with status 201 Created and the full resource
        return ResponseEntity.status(HttpStatus.CREATED).body(measurableIndicatorResource);
    }

}
