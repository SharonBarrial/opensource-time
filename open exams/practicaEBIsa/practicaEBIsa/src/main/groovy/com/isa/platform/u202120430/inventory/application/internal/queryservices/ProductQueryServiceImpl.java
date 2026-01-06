package com.isa.platform.u202120430.inventory.application.internal.queryservices;

import com.isa.platform.u202120430.inventory.domain.model.aggregates.Product;
import com.isa.platform.u202120430.inventory.domain.model.queries.GetProductByIdQuery;
import com.isa.platform.u202120430.inventory.domain.services.ProductQueryService;
import com.isa.platform.u202120430.inventory.infrastructure.persistence.jpa.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */

@Service
public class ProductQueryServiceImpl implements ProductQueryService {
    private final ProductRepository productRepository;

    public ProductQueryServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> handle(GetProductByIdQuery query) {
        return this.productRepository.findById(query.productId());
    }
}
