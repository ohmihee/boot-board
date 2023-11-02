package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.controller.dto.CategoryCdo;
import org.example.domain.Category;
import org.example.service.CategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/")
    public Category registerCategory(@RequestBody CategoryCdo categoryCdo) {
        return categoryService.registerCategory(categoryCdo);
    }

}
