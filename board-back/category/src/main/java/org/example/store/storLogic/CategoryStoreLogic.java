package org.example.store.storLogic;

import org.example.domain.Category;

import java.util.Optional;

public interface CategoryStoreLogic {
   Category getCategoryByCode (String code);
    Category registerCategory(Category category);

    Boolean existsCategoryByCodeAndDepth(String code, Integer depth);
}
