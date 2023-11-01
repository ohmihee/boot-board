package org.example.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String id;
    @Column(name="NAME", length=20, nullable=false, unique=false)
    private String name;
    @Column(name="CODE", length=20, nullable=false, unique=true)
    private String code;
    @ElementCollection
    @Column(name = "IN_CATEGORIes", nullable = false)
    private List<String> inCategories = new ArrayList<>();

}
