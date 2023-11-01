package org.example.store.storLogic.storeLogicImpl;

import org.example.domain.Category;
import org.example.store.CategoryRepository;
import org.example.store.storLogic.CategoryStoreLogic;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class CategoryStoreLogicImpl implements CategoryStoreLogic {

    private final CategoryRepository categoryRepository;

    CategoryStoreLogicImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category getCategoryByCode(String code) {
        Category category = categoryRepository.findCategoryByCode(code).orElseThrow(
                () -> new RuntimeException("해당 카테고리가 존재하지 않습니다.")
        );
        return category;
    }

    @Override
    public Category registerCategory(Category category) {
        boolean dbCategory = categoryRepository.findCategoryByCode(category.getCode()).isPresent();
        if (dbCategory) {
            throw new RuntimeException(category.getCode()+"에 해당하는 카테고리가 존재합니다.");
        }
        return categoryRepository.save(category);
    }
}
