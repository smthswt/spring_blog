package com.sprint.demo.spring_blog.entity;


import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

/**
 * - id: UUID (이미지 ID)
 * - originalName: String (원본 파일명)
 * - extension: String (확장자)
 * - path: String (저장 경로)
 * - size: Long (파일 크기)
 * - uploadedAt: Instant (업로드 일시)
 */

@Getter
public class Image implements Serializable {
    @Serial
    private static final long serialVersionUID = 3L;
    private final UUID id;
    private String originalName;
    private String extension;
    private String path;
    private Long size;
    private final Instant uploadedAt;

    public Image(String originalName, String extension, String path, Long size) {
        this.id = UUID.randomUUID();
        this.originalName = originalName;
        this.extension = extension;
        this.path = path;
        this.size = size;
        this.uploadedAt = Instant.now();
    }
}
