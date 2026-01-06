package com.isa.platform.u202120430.inventory.infrastructure.persistence.jpa.repositories;

import com.isa.platform.u202120430.inventory.domain.model.aggregates.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
