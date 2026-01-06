package com.isa.platform.u20221b127.monitoring.infrastructure.persistence.jpa.repositories;

import com.isa.platform.u20221b127.inventory.domain.model.aggregates.Product;
import com.isa.platform.u20221b127.monitoring.domain.model.aggregates.Snapshot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SnapshotRepository extends JpaRepository<Snapshot, Long> {
    Optional<Snapshot> findBySnapshotId(String snapshotId);
    List<Snapshot> findAllByProduct(Product product);
}
