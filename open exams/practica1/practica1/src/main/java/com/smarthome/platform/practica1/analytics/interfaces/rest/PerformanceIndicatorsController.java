package com.smarthome.platform.practica1.analytics.interfaces.rest;

import com.smarthome.platform.practica1.analytics.domain.model.queries.GetAllPerformanceIndicatorsQuery;
import com.smarthome.platform.practica1.analytics.domain.services.PerformanceIndicatorCommandService;
import com.smarthome.platform.practica1.analytics.domain.services.PerformanceIndicatorQueryService;
import com.smarthome.platform.practica1.analytics.interfaces.rest.resources.CreatePerformanceIndicatorResource;
import com.smarthome.platform.practica1.analytics.interfaces.rest.resources.PerformanceIndicatorResource;
import com.smarthome.platform.practica1.analytics.interfaces.rest.transform.CreatePerformanceIndicatorCommandFromResourceAssembler;
import com.smarthome.platform.practica1.analytics.interfaces.rest.transform.PerformanceIndicatorResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Performance Indicators Controller
 * <p>
 *     This class represents the REST API for the performance indicators.
 *     It provides endpoints to get all performance indicators and create a performance indicator.
 * </p>
 * @author Salvador Salinas
 * @version 1.0
 */
@RestController
@RequestMapping(value = "api/v1/performance-indicators", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Performance Indicators", description = "Performance Indicators Endpoints")
public class PerformanceIndicatorsController {
    private final PerformanceIndicatorCommandService performanceIndicatorCommandService;
    private final PerformanceIndicatorQueryService performanceIndicatorQueryService;

    public PerformanceIndicatorsController(PerformanceIndicatorCommandService performanceIndicatorCommandService, PerformanceIndicatorQueryService performanceIndicatorQueryService) {
        this.performanceIndicatorCommandService = performanceIndicatorCommandService;
        this.performanceIndicatorQueryService = performanceIndicatorQueryService;
    }

    @Operation(summary = "Get all performance indicators")
    @GetMapping
    public ResponseEntity<List<PerformanceIndicatorResource>> getAllPerformanceIndicators() {
        var getAllPerformanceIndicatorsQuery = new GetAllPerformanceIndicatorsQuery();
        var performanceIndicators = performanceIndicatorQueryService.handle(getAllPerformanceIndicatorsQuery);
        var performanceIndicatorResources = performanceIndicators.stream()
                .map(PerformanceIndicatorResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(performanceIndicatorResources);
    }

    @Operation(summary = "Create a performance indicator")
    @PostMapping
    public ResponseEntity<PerformanceIndicatorResource> createPerformanceIndicator(@RequestBody CreatePerformanceIndicatorResource resource) {
        var createPerformanceIndicatorCommand = CreatePerformanceIndicatorCommandFromResourceAssembler.toCommandFromResource(resource);
        var performanceIndicator = performanceIndicatorCommandService.handle(createPerformanceIndicatorCommand);
        if (performanceIndicator.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var performanceIndicatorResource = PerformanceIndicatorResourceFromEntityAssembler.toResourceFromEntity(performanceIndicator.get());
        return new ResponseEntity<>(performanceIndicatorResource, HttpStatus.CREATED);
    }

}
