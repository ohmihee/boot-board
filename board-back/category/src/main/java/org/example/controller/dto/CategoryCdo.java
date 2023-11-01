package org.example.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryCdo {
    private String name;
    private String code;
    private List<String> inCategories;
}
