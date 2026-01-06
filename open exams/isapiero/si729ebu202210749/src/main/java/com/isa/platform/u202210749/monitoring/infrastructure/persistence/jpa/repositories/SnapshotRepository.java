package com.isa.platform.u202210749.monitoring.infrastructure.persistence.jpa.repositories;

import com.isa.platform.u202210749.monitoring.domain.model.aggregates.Snapshot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SnapshotRepository extends JpaRepository<Snapshot, Long> {
    boolean existsBySnapshotId(String snapshotId);
    List<Snapshot> findByProductSerialNumber(String serialNumber);
}
