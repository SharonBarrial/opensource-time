package com.isa.platform.u202210749.inventory.infrastructure.persistence.jpa.repositories;

import com.isa.platform.u202210749.inventory.domain.model.aggregates.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findBySerialNumber(String serialNumber);
}
