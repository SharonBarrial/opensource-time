package com.isa.platform.u20221b127.monitoring.application.internal.commandservices;

import com.isa.platform.u20221b127.inventory.infrastructure.persistence.jpa.repositories.ProductRepository;
import com.isa.platform.u20221b127.monitoring.domain.exceptions.ProductNotFoundException;
import com.isa.platform.u20221b127.monitoring.domain.model.aggregates.Snapshot;
import com.isa.platform.u20221b127.monitoring.domain.model.commands.CreateSnapshotCommand;
import com.isa.platform.u20221b127.monitoring.domain.services.SnapshotCommandService;
import com.isa.platform.u20221b127.monitoring.infrastructure.persistence.jpa.repositories.SnapshotRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class SnapshotCommandServiceImpl implements SnapshotCommandService {
    private final SnapshotRepository snapshotRepository;
    private final ProductRepository productRepository;

    public SnapshotCommandServiceImpl(SnapshotRepository snapshotRepository, ProductRepository productRepository) {
        this.snapshotRepository = snapshotRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Snapshot> handle(CreateSnapshotCommand command, Long productId) {
        var product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException(productId));

        // check if product has monitoring level ADVANCE_MONITORING
        if (Objects.equals(product.getMonitoringLevel(), "ADVANCE_MONITORING")) {
            if (command.energy() == null)
                throw new IllegalArgumentException("Energy is mandatory for snapshots of products with monitoring level ADVANCE_MONITORING");
            if (command.leakage() == null)
                throw new IllegalArgumentException("Leakage is mandatory for snapshots of products with monitoring level ADVANCE_MONITORING");
        }

        // check if product has monitoring level ESSENTIAL_MONITORING
        if (Objects.equals(product.getMonitoringLevel(), "ESSENTIAL_MONITORING")) {
            if (command.energy() != null || command.leakage() != null)
                throw new IllegalArgumentException("Energy and Leakage are not allowed for snapshots of products with monitoring level ESSENTIAL_MONITORING");
        }

        // check if snapshotId already exists
        var existsSnapshot = snapshotRepository.findBySnapshotId(command.snapshotId());
        if (existsSnapshot.isPresent()) {
            return Optional.empty();
        }
        var snapshot = new Snapshot(command, product);
        try {
            snapshotRepository.save(snapshot);
        }
        catch (Exception e) {
            throw new IllegalArgumentException("Error creating snapshot: " + e.getMessage());
        }
        return Optional.of(snapshot);

    }
}
