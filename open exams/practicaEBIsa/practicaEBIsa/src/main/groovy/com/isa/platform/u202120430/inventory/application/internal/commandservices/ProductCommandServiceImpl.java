package com.isa.platform.u202120430.inventory.application.internal.commandservices;

import com.isa.platform.u202120430.inventory.domain.model.aggregates.Product;
import com.isa.platform.u202120430.inventory.domain.model.commands.CreateProductCommand;
import com.isa.platform.u202120430.inventory.domain.model.exceptions.ProductSaveException;
import com.isa.platform.u202120430.inventory.domain.services.ProductCommandService;
import com.isa.platform.u202120430.inventory.infrastructure.persistence.jpa.repositories.ProductRepository;
import com.isa.platform.u202120430.shared.domain.model.entities.MonitoringLevel;
import com.isa.platform.u202120430.shared.domain.model.exceptions.MonitoringLevelNotFoundException;
import com.isa.platform.u202120430.shared.domain.model.valueobjects.MonitoringLevelName;
import com.isa.platform.u202120430.shared.infrastructure.persistence.jpa.repositories.MonitoringLevelRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */

@Service
public class ProductCommandServiceImpl implements ProductCommandService {
    private final ProductRepository productRepository;
    private final MonitoringLevelRepository monitoringLevelRepository;

    public ProductCommandServiceImpl(ProductRepository productRepository, MonitoringLevelRepository monitoringLevelRepository) {
        this.productRepository = productRepository;
        this.monitoringLevelRepository = monitoringLevelRepository;
    }

    @Override
    public Long handle(CreateProductCommand command) {
        //Convert the monitoring level string to a MonitoringLevel enum
        MonitoringLevelName monitoringLevelName;
        try {
            monitoringLevelName = MonitoringLevelName.valueOf(command.monitoringLevel());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Monitoring level not found");
        }

        //Check if monitoring level exists
        Optional<MonitoringLevel> optionalMonitoringLevel = monitoringLevelRepository.findByLevel(MonitoringLevelName.valueOf(monitoringLevelName.name()));
        MonitoringLevel monitoringLevel = optionalMonitoringLevel.orElseThrow(() -> new MonitoringLevelNotFoundException(command.monitoringLevel()));

        //Create and save the product
        var product = new Product(command, monitoringLevel);
        try {
            productRepository.save(product);
        } catch (Exception e) {
            throw new ProductSaveException("Error saving product", e);
        }
        return product.getId();
    }
}
