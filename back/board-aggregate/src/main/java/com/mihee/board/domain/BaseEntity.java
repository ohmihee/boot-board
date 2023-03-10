package com.mihee.board.domain;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;

@Getter
@Setter
public class BaseEntity {
    @Id
    private String id;
    @CreatedDate
    private Long createDateTime;
    @LastModifiedDate
    private Long lastModifiedDate;

}
