package org.example.controller.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.domain.Category;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CategoryCdo {
    private String name;
    private String code;
    private List<CategoryCdo> inCategories;

    public Category toDomain() {
        return new Category(code, name,  new ArrayList<>());
    }
}
