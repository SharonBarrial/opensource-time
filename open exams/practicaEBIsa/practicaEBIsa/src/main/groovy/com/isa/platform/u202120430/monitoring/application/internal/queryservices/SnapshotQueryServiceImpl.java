package com.isa.platform.u202120430.monitoring.application.internal.queryservices;

import com.isa.platform.u202120430.monitoring.domain.model.aggregates.Snapshot;
import com.isa.platform.u202120430.monitoring.domain.model.queries.GetSnapshotByIdQuery;
import com.isa.platform.u202120430.monitoring.domain.model.queries.GetSnapshotsByProductIdQuery;
import com.isa.platform.u202120430.monitoring.domain.services.SnapshotQueryService;
import com.isa.platform.u202120430.monitoring.infrastructure.persistence.jpa.repositories.SnapshotRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */

@Service
public class SnapshotQueryServiceImpl implements SnapshotQueryService {
    private final SnapshotRepository snapshotRepository;

    public SnapshotQueryServiceImpl(SnapshotRepository snapshotRepository) {
        this.snapshotRepository = snapshotRepository;
    }

    @Override
    public Optional<Snapshot> handle(GetSnapshotByIdQuery query) {
        return this.snapshotRepository.findById(query.snapshotId());
    }

    @Override
    public List<Snapshot> handle(GetSnapshotsByProductIdQuery query) {
        return this.snapshotRepository.findAllByProductId(query.productId());
    }
}
