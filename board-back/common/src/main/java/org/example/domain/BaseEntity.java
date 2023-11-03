package org.example.domain;

import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity implements Serializable {
    private Long createdBy;
    private LocalDateTime createdAt;
    private Long lastModifiedBy;
    private LocalDateTime lastModifiedAt;
}
