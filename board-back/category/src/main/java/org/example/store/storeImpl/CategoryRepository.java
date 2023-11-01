package org.example.store.storeImpl;

import org.example.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
    Category findCategoryByCode (String code);

}

