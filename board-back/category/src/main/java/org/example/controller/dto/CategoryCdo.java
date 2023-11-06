package org.example.controller.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.domain.Category;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CategoryCdo {
    private Integer depth;
    private String name;
    private String code;
    private List<CategoryCdo> inCategories;

//    public Category toDomain() {
//        return new Category(code, name,  new ArrayList<>());
//    }

    CategoryCdo (String name, String code) {
        this.name = name;
        this.code = code;
        this.depth = 0;
    }
    public Category toDomain (){
        Category category = new Category();
        BeanUtils.copyProperties(this, category);
        return category;
    }

    public static void main(String[] args){
        CategoryCdo cdo =new CategoryCdo("사용자" , "0001");
        Category category = cdo.toDomain();
        System.out.println(category);
    }
}
