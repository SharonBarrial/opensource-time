package com.isa.platform.u20221b127.monitoring.application.internal.queryservices;

import com.isa.platform.u20221b127.inventory.infrastructure.persistence.jpa.repositories.ProductRepository;
import com.isa.platform.u20221b127.monitoring.domain.model.aggregates.Snapshot;
import com.isa.platform.u20221b127.monitoring.domain.model.queries.GetSnapshotsByProductIdQuery;
import com.isa.platform.u20221b127.monitoring.domain.services.SnapshotQueryService;
import com.isa.platform.u20221b127.monitoring.infrastructure.persistence.jpa.repositories.SnapshotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SnapshotQueryServiceImpl implements SnapshotQueryService {
    private final SnapshotRepository snapshotRepository;
    private final ProductRepository productRepository;

    public SnapshotQueryServiceImpl(SnapshotRepository snapshotRepository, ProductRepository productRepository) {
        this.snapshotRepository = snapshotRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Snapshot> handle(GetSnapshotsByProductIdQuery query) {
        var product = productRepository.findById(query.productId());
        if (product.isEmpty()) {
            throw new IllegalArgumentException("Product not found");
        }
        return snapshotRepository.findAllByProduct(product.get());
    }
}
