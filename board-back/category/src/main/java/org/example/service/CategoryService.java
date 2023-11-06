package org.example.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.controller.dto.CategoryCdo;
import org.example.domain.Category;
import org.example.store.storLogic.CategoryStoreLogic;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryStoreLogic categoryStoreLogic;

    public Category registerCategory(CategoryCdo categoryCdo) {

        return categoryStoreLogic.registerCategory(categoryCdo.toDomain());
    }

    private void registerInCategory (List<CategoryCdo> categoryCdoList) {
        categoryCdoList.stream().forEach(it -> {

        });


    }

    public Category findCategoryByCode (String code) {
        return categoryStoreLogic.getCategoryByCode(code);
    }
}
