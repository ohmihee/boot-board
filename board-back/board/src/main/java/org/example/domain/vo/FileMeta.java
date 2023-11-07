package org.example.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class FileMeta {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name="FILE_NAME")
    private String fileName;
    @Column(name="FILE_SIZE")
    private long fileSize;
    @Column(name="MIMETYPE")
    private String mimeType;

    FileMeta(String fileName, long fileSize, String mimeType) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.mimeType = mimeType;
    }
}
