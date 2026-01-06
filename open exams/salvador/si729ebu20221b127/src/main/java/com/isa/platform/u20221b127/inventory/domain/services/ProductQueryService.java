package com.isa.platform.u20221b127.inventory.domain.services;

import com.isa.platform.u20221b127.inventory.domain.model.aggregates.Product;
import com.isa.platform.u20221b127.inventory.domain.model.queries.GetProductByIdQuery;

import java.util.Optional;

public interface ProductQueryService {
    Optional<Product> handle(GetProductByIdQuery query);
}
