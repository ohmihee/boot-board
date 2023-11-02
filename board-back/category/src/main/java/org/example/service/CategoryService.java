package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.controller.dto.CategoryCdo;
import org.example.domain.Category;
import org.example.store.storLogic.CategoryStoreLogic;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryStoreLogic categoryStoreLogic;

    public Category registerCategory(CategoryCdo categoryCdo) {
        return categoryStoreLogic.registerCategory(categoryCdo.toDomain());
    }
}
