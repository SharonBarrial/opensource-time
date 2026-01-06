package com.isa.platform.u202120430.inventory.domain.services;

import com.isa.platform.u202120430.inventory.domain.model.aggregates.Product;
import com.isa.platform.u202120430.inventory.domain.model.queries.GetProductByIdQuery;

import java.util.Optional;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */
public interface ProductQueryService {
    Optional<Product> handle(GetProductByIdQuery query);
}
