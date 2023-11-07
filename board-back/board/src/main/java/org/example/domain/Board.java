package org.example.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.domain.vo.BoardType;
import org.example.domain.vo.FileMeta;
import org.example.entity.BaseEntity;

import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class Board extends BaseEntity {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name="TITLE")
    private String title;
    @Column(name="CONTENT" )
    private String content;
    @Column(name="CONTENT_TYPE")
    @Enumerated(EnumType.STRING)
    private BoardType type;
    @Column(name="FILE_ID")
    private String fileId;
}
