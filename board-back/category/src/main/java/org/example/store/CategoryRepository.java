package org.example.store;

import org.example.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, String> {
    Optional<Category> findCategoryByCode (String code);
    Boolean existsCategoryByCodeAndDepth(String code, Integer detpth);
}

