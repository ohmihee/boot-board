package org.example.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.BaseEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name="categories")
@NoArgsConstructor()
public class Category extends BaseEntity {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name="NAME", length=20, nullable=false, unique=false)
    private String name;
    @Column(name="CODE", length=20, nullable=false, unique=true)
    private String code;
    @Column(name="DEPTH", nullable = true)
    private Integer depth;

    public Category(String code, String name){
        this.depth = 1;
        this.code = code;
        this.name = name;
        //this.inCategories = inCategories;
    }
}
