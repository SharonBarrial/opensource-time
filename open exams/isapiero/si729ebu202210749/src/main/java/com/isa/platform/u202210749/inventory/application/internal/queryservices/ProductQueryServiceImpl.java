package com.isa.platform.u202210749.inventory.application.internal.queryservices;

import com.isa.platform.u202210749.inventory.domain.model.aggregates.Product;
import com.isa.platform.u202210749.inventory.domain.model.queries.GetProductByIdQuery;
import com.isa.platform.u202210749.inventory.domain.model.queries.GetProductBySerialNumberQuery;
import com.isa.platform.u202210749.inventory.domain.services.ProductQueryService;
import com.isa.platform.u202210749.inventory.infrastructure.persistence.jpa.repositories.ProductRepository;
import com.isa.platform.u202210749.monitoring.infrastructure.persistence.jpa.repositories.SnapshotRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductQueryServiceImpl implements ProductQueryService {
    private final ProductRepository productRepository;

    public ProductQueryServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> handle(GetProductBySerialNumberQuery query) {
        return productRepository.findBySerialNumber(query.serialNumber());
    }

    @Override
    public Optional<Product> handle(GetProductByIdQuery query) {
        return productRepository.findById(query.productId());
    }

}
