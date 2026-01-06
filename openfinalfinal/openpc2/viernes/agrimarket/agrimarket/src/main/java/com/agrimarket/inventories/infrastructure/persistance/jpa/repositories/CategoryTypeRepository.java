package com.agrimarket.inventories.infrastructure.persistance.jpa.repositories;

import com.agrimarket.inventories.domain.model.entities.CategoryType;
import com.agrimarket.inventories.domain.model.valueobjects.CategoryTypeName;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA Repository for CategoryType entity.
 * @version 1.0
 * @author Sharon Antuanet Ivet Barrial Marin
 */

public interface CategoryTypeRepository extends JpaRepository<CategoryType, Long> {
    boolean existsByName(CategoryTypeName name);
}
