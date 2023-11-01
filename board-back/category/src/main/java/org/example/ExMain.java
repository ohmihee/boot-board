package org.example;

import lombok.RequiredArgsConstructor;
import org.example.domain.Category;
import org.example.store.storeImpl.CategoryRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@RequiredArgsConstructor
public class ExMain {

    private final CategoryRepository categoryRepository;
    public void saveCategory() {
        Category category = new Category();
        categoryRepository.save(category);
    }

    public Category readCategory(String id) {
        return categoryRepository.findById(id).get();
    }
}
