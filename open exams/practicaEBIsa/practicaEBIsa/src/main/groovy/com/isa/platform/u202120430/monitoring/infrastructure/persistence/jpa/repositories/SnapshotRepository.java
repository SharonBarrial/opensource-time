package com.isa.platform.u202120430.monitoring.infrastructure.persistence.jpa.repositories;

import com.isa.platform.u202120430.monitoring.domain.model.aggregates.Snapshot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */
public interface SnapshotRepository extends JpaRepository<Snapshot, Long> {
    List<Snapshot> findAllByProductId(Long advisorId);
}
