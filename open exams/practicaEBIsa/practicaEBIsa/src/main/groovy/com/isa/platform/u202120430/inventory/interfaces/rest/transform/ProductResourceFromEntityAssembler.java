package com.isa.platform.u202120430.inventory.interfaces.rest.transform;

import com.isa.platform.u202120430.inventory.domain.model.aggregates.Product;
import com.isa.platform.u202120430.inventory.interfaces.rest.resources.ProductResource;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */
public class ProductResourceFromEntityAssembler {
    public static ProductResource toResourceFromEntity(Product entity) {
        return new ProductResource(
                entity.getId(),
                entity.getBrand(),
                entity.getModel(),
                entity.getSerialNumber(),
                entity.getMonitoringLevel().getLevel().name()
        );
    }
}
