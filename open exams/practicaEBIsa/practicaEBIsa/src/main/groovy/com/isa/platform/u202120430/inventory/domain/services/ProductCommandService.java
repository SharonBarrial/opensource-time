package com.isa.platform.u202120430.inventory.domain.services;

import com.isa.platform.u202120430.inventory.domain.model.commands.CreateProductCommand;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */
public interface ProductCommandService {
    Long handle(CreateProductCommand command);
}
