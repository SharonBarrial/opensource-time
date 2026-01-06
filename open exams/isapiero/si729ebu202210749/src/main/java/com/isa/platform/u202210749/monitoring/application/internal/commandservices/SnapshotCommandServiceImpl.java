package com.isa.platform.u202210749.monitoring.application.internal.commandservices;

import com.isa.platform.u202210749.inventory.infrastructure.persistence.jpa.repositories.ProductRepository;
import com.isa.platform.u202210749.monitoring.domain.exceptions.*;
import com.isa.platform.u202210749.monitoring.domain.model.aggregates.Snapshot;
import com.isa.platform.u202210749.monitoring.domain.model.commands.CreateSnapshotCommand;
import com.isa.platform.u202210749.monitoring.domain.services.SnapshotCommandService;
import com.isa.platform.u202210749.monitoring.infrastructure.persistence.jpa.repositories.SnapshotRepository;
import org.springframework.stereotype.Service;

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
        if(snapshotRepository.existsBySnapshotId(command.snapshotId())) {
            throw new SameSnapshotIdException(command.snapshotId());
        }
        var product = productRepository.findBySerialNumber(command.productSerialNumber());
        if(product.isEmpty()) { throw new ProductWithSerialNumberNotFoundException(command.productSerialNumber()); }

        if(product.get().getMonitoringLevel().getName().equals("ADVANCED_MONITORING")) {
            if(command.energy() == null) {
                throw new EnergyRequiredException();
            }
            if(command.leakage() == null) {
                throw new LeakageRequiredException();
            }

            if(command.leakage() != 0 && command.leakage() != 1) {
                throw new LeakageInvalidRangeException(command.leakage());
            }
        }
        else{
            if(command.energy() != null || command.leakage() != null){
                throw new IncompatibleMonitoringLevelException();
            }
        }
        Snapshot snapshot = new Snapshot(command);
        try {
            snapshotRepository.save(snapshot);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving snapshot: " + e.getMessage());
        }
        return snapshot.getId();
    }
}
