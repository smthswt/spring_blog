package com.sprint.demo.spring_blog.entity;


import lombok.Getter;

import java.io.Serializable;
import java.util.UUID;

/**
 * - id: UUID (연결 ID)
 * - postId: String (게시물 ID)
 * - imageId: String (이미지 ID)
 */

@Getter
public class PostImage implements Serializable {
    private static final long serialVersionUID = 4L;
    private final UUID id;
    private UUID postId;
    private UUID imageId;

    public PostImage(UUID postId, UUID imageId) {
        this.id = UUID.randomUUID();
        this.postId = postId;
        this.imageId = imageId;
    }
}
