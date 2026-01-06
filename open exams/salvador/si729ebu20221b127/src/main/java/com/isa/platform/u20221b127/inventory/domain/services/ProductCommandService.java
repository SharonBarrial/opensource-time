package com.isa.platform.u20221b127.inventory.domain.services;

import com.isa.platform.u20221b127.inventory.domain.model.aggregates.Product;
import com.isa.platform.u20221b127.inventory.domain.model.commands.CreateProductCommand;

import java.util.Optional;

public interface ProductCommandService {
    Optional<Product> handle(CreateProductCommand command);
}
