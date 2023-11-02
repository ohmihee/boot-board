package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExMain {
    public static void main(String[] args) {
        SpringApplication.run(ExMain.class, args);

    }

//    private final CategoryRepository categoryRepository;
//    public void saveCategory(Category category) {
////        Category newCategory = new Category();
////        categoryRepository.save(category);
//    }
//
//    public Category readCategory(String id) {
//        return categoryRepository.findById(id).get();
//    }
}
