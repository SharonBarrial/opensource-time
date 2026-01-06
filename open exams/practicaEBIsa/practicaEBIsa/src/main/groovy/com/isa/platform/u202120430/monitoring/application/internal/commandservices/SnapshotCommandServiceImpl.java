package com.isa.platform.u202120430.monitoring.application.internal.commandservices;

import com.isa.platform.u202120430.inventory.domain.model.aggregates.Product;
import com.isa.platform.u202120430.inventory.infrastructure.persistence.jpa.repositories.ProductRepository;
import com.isa.platform.u202120430.monitoring.domain.model.aggregates.Snapshot;
import com.isa.platform.u202120430.monitoring.domain.model.commands.CreateSnapshotCommand;
import com.isa.platform.u202120430.monitoring.domain.services.SnapshotCommandService;
import com.isa.platform.u202120430.monitoring.infrastructure.persistence.jpa.repositories.SnapshotRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */

@Service
public class SnapshotCommandServiceImpl implements SnapshotCommandService {
    private final SnapshotRepository snapshotRepository;
    private final ProductRepository productRepository;

    public SnapshotCommandServiceImpl(SnapshotRepository snapshotRepository, ProductRepository productRepository) {
        this.snapshotRepository = snapshotRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Long handle(CreateSnapshotCommand command) {
        //check if product exists
        Optional<Product> optionalProduct = productRepository.findById(command.productId());
        Product product = optionalProduct.orElseThrow(() -> new IllegalArgumentException("Product not found"));

        //Create and save the snapshot
        Snapshot snapshot = new Snapshot(command, product);
        try {
            snapshotRepository.save(snapshot);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error saving snapshot");
        }
        return snapshot.getId();
    }
}
