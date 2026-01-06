package com.isa.platform.u202210749.inventory.domain.services;

import com.isa.platform.u202210749.inventory.domain.model.commands.CreateProductCommand;

public interface ProductCommandService {
    Long handle(CreateProductCommand createProductCommand);
}
