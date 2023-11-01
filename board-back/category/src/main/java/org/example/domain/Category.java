package org.example.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
public class Category implements Serializable {
    @Id
    private String id;
    private String name;
    @Column(unique=true)
    private String code;
    //private Category inCategory;

}
