package com.isa.platform.u202120430.monitoring.interfaces.rest;

import com.isa.platform.u202120430.monitoring.domain.model.aggregates.Snapshot;
import com.isa.platform.u202120430.monitoring.domain.model.queries.GetSnapshotByIdQuery;
import com.isa.platform.u202120430.monitoring.domain.model.queries.GetSnapshotsByProductIdQuery;
import com.isa.platform.u202120430.monitoring.domain.services.SnapshotCommandService;
import com.isa.platform.u202120430.monitoring.domain.services.SnapshotQueryService;
import com.isa.platform.u202120430.monitoring.interfaces.rest.resources.CreateSnapshotResource;
import com.isa.platform.u202120430.monitoring.interfaces.rest.resources.SnapshotResource;
import com.isa.platform.u202120430.monitoring.interfaces.rest.transform.CreateSnapshotCommandFromResourceAssembler;
import com.isa.platform.u202120430.monitoring.interfaces.rest.transform.SnapshotResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */

@RestController
@RequestMapping(value = "api/v1/snapshots", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Snapshot", description = "Snapshot Management Endpoints")
public class SnapshotController {
    private final SnapshotCommandService snapshotCommandService;
    private final SnapshotQueryService snapshotQueryService;

    public SnapshotController(SnapshotCommandService snapshotCommandService, SnapshotQueryService snapshotQueryService) {
        this.snapshotCommandService = snapshotCommandService;
        this.snapshotQueryService = snapshotQueryService;
    }

    @PostMapping
    public ResponseEntity<SnapshotResource> CreateSnapshot(@RequestBody CreateSnapshotResource res) {
        var createSnapshotCommand = CreateSnapshotCommandFromResourceAssembler.toCommandFromResource(res);
        var snapshotId = snapshotCommandService.handle(createSnapshotCommand);
        if (snapshotId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getSnapshotByIdQuery = new GetSnapshotByIdQuery(snapshotId);
        var snapshot = snapshotQueryService.handle(getSnapshotByIdQuery);
        if (snapshot.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var snapshotResource = SnapshotResourceFromEntityAssembler.toResourceFromEntity(snapshot.get());
        return new ResponseEntity<>(snapshotResource, HttpStatus.CREATED);
    }

    @GetMapping("/{productId}/snapshots")
    public ResponseEntity<List<SnapshotResource>> getSnapshots(@PathVariable Long productId) {
        var getSnapshotsByProductIdQuery = new GetSnapshotsByProductIdQuery(productId);
        var snapshots = snapshotQueryService.handle(getSnapshotsByProductIdQuery);
        if (snapshots.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        var snapshotResources = snapshots.stream()
                .map(SnapshotResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(snapshotResources);
    }
}
