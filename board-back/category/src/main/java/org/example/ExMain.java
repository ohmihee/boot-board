package org.example;

import lombok.RequiredArgsConstructor;
import org.example.domain.Category;
import org.example.store.CategoryRepository;

@RequiredArgsConstructor
public class ExMain {

    private final CategoryRepository categoryRepository;
    public void saveCategory(Category category) {
        Category newCategory = new Category();
        categoryRepository.save(category);
    }

    public Category readCategory(String id) {
        return categoryRepository.findById(id).get();
    }
}
