package com.isa.platform.u20221b127.inventory.infrastructure.persistence.jpa.repositories;

import com.isa.platform.u20221b127.inventory.domain.model.aggregates.Product;
import com.isa.platform.u20221b127.inventory.domain.model.valueobjects.SerialNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsBySerialNumber(SerialNumber serialNumber);

}
