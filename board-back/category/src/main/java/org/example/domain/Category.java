package org.example.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.BaseEntity;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name="category")
@NoArgsConstructor()
public class Category extends BaseEntity {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name="NAME", length=20, nullable=false, unique=false)
    private String name;
    @Column(name="CODE", length=20, nullable=false, unique=true)
    private String code;
    @ElementCollection
    @Column(name = "IN_CATEGORIes", nullable = false)
    private List<String> inCategories = new ArrayList<>();

    public Category(String code, String name, List<String> inCategories){
        this.code = code;
        this.name = name;
        this.inCategories = inCategories;


    }
}
