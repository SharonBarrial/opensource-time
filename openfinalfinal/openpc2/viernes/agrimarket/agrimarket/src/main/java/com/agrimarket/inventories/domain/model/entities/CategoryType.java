package com.agrimarket.inventories.domain.model.entities;

import com.agrimarket.inventories.domain.model.valueobjects.CategoryTypeName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

/**
 * CategoryType entity
 * @author Sharon Antuanet Ivet Barrial Marin
 * @version 1.0
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@With
public class CategoryType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private CategoryTypeName name;

    /**
     * Constructor
     * @param name Group type name
     */

    public CategoryType(CategoryTypeName name) {
        this.name = name;
    }


}
