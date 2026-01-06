package com.agrimarket.inventories.application.internal.commandservices;

import com.agrimarket.inventories.domain.model.commands.CreateEquipmentCommand;
import com.agrimarket.inventories.domain.model.commands.SeedCategoryTypeCommand;
import com.agrimarket.inventories.domain.model.entities.CategoryType;
import com.agrimarket.inventories.domain.model.valueobjects.CategoryTypeName;
import com.agrimarket.inventories.domain.services.CategoryTypeCommandService;
import com.agrimarket.inventories.infrastructure.persistance.jpa.repositories.CategoryTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryTypeCommandServiceImpl implements CategoryTypeCommandService {
    private final CategoryTypeRepository categoryTypeRepository;

    public CategoryTypeCommandServiceImpl(CategoryTypeRepository categoryTypeRepository) {
        this.categoryTypeRepository = categoryTypeRepository;
    }

    /**
     *
     */

    @Override
    public Long handle(SeedCategoryTypeCommand command) {
        CategoryTypeName[] categoryTypes = CategoryTypeName.values();
        Long lastId = null;

        for (CategoryTypeName typeName : categoryTypes) {
            if (!categoryTypeRepository.existsByName(typeName)) {
                CategoryType categoryType = new CategoryType(typeName);
                categoryTypeRepository.save(categoryType);
                lastId = categoryType.getId();
            }
        }
        return lastId;
    }
}
