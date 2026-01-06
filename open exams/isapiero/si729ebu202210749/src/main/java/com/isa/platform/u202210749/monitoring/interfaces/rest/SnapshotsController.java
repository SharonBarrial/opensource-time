package com.isa.platform.u202210749.monitoring.interfaces.rest;

import com.isa.platform.u202210749.monitoring.domain.model.aggregates.Snapshot;
import com.isa.platform.u202210749.monitoring.domain.model.queries.GetSnapshotByIdQuery;
import com.isa.platform.u202210749.monitoring.domain.model.queries.GetSnapshotsByProductIdQuery;
import com.isa.platform.u202210749.monitoring.domain.services.SnapshotCommandService;
import com.isa.platform.u202210749.monitoring.domain.services.SnapshotQueryService;
import com.isa.platform.u202210749.monitoring.interfaces.rest.resources.CreateSnapshotResource;
import com.isa.platform.u202210749.monitoring.interfaces.rest.resources.SnapshotResource;
import com.isa.platform.u202210749.monitoring.interfaces.rest.transform.CreateSnapshotCommandFromResourceAssembler;
import com.isa.platform.u202210749.monitoring.interfaces.rest.transform.SnapshotResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value="api/v1/products/{productId}/snapshots",produces = APPLICATION_JSON_VALUE)
@Tag(name = "Product Snapshots", description = "Product Snapshots Management Endpoints")
public class SnapshotsController {
    private final SnapshotCommandService snapshotCommandService;
    private final SnapshotQueryService snapshotQueryService;

    public SnapshotsController(SnapshotCommandService snapshotCommandService, SnapshotQueryService snapshotQueryService) {
        this.snapshotCommandService = snapshotCommandService;
        this.snapshotQueryService = snapshotQueryService;
    }

    @GetMapping
    public ResponseEntity<?> getSnapshotsByProductId(@PathVariable Long productId){
        var getSnapshotsByProductIdQuery = new GetSnapshotsByProductIdQuery(productId);
        List<Snapshot> snapshots;
        try {
            snapshots = snapshotQueryService.handle(getSnapshotsByProductIdQuery);
        } catch (Exception e){
            return ResponseEntity.notFound().build();

        }
        var snapshotResources = snapshots.stream()
                .map(SnapshotResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(snapshotResources);
    }

    @PostMapping
    public ResponseEntity<?> createSnapshot(@RequestBody CreateSnapshotResource createSnapshotResource){
        var createSnapshotCommand = CreateSnapshotCommandFromResourceAssembler.toCommandFromResource(createSnapshotResource);
        Long snapshotId;
        try {
            snapshotId = snapshotCommandService.handle(createSnapshotCommand);
        } catch (Exception e){
            return ResponseEntity
                    .badRequest()
                    .contentType(MediaType.TEXT_PLAIN)
                    .body(e.getMessage());
        }
        if (snapshotId == 0L){
            return ResponseEntity.badRequest().build();
        }
        var getSnapshotByIdQuery = new GetSnapshotByIdQuery(snapshotId);
        var snapshot = snapshotQueryService.handle(getSnapshotByIdQuery);
        if (snapshot.isEmpty()){ return ResponseEntity.badRequest().build(); }
        var snapshotResource = SnapshotResourceFromEntityAssembler.toResourceFromEntity(snapshot.get());
        return new ResponseEntity<>(snapshotResource, HttpStatus.CREATED);
    }
}
