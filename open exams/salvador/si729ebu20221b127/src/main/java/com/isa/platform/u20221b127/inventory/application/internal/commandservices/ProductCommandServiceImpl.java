package com.isa.platform.u20221b127.inventory.application.internal.commandservices;

import com.isa.platform.u20221b127.inventory.domain.model.aggregates.Product;
import com.isa.platform.u20221b127.inventory.domain.model.commands.CreateProductCommand;
import com.isa.platform.u20221b127.inventory.domain.model.valueobjects.MonitoringLevel;
import com.isa.platform.u20221b127.inventory.domain.model.valueobjects.SerialNumber;
import com.isa.platform.u20221b127.inventory.domain.services.ProductCommandService;
import com.isa.platform.u20221b127.inventory.infrastructure.persistence.jpa.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductCommandServiceImpl implements ProductCommandService {
    private final ProductRepository productRepository;

    public ProductCommandServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> handle(CreateProductCommand command) {
        var serialNumber = new SerialNumber(command.serialNumber());
        if (productRepository.existsBySerialNumber(serialNumber)) {
            throw new IllegalArgumentException("Product with serial number " + serialNumber.serialNumber() + " already exists");
        }
        try {
            var checkMonitoringLevel = MonitoringLevel.valueOf(command.monitoringLevel().toUpperCase());
            var product = new Product(command);
            try {
                productRepository.save(product);
                return Optional.of(product);
            } catch (Exception e) {
                throw new IllegalArgumentException("Error saving product: " + e.getMessage());
            }
        }
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid monitoring level. Must be ESSENTIAL_MONITORING or ADVANCE_MONITORING");
        }

    }
}
