package com.sprint.demo.spring_blog.entity;

import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

/**
 * - id: UUID (게시물 ID)
 * - title: String (제목)
 * - content: String (내용, 2-1000자)
 * - authorId: UUID (작성자 ID)
 * - tags: List<String> (태그 목록, 영문만 허용)
 * - createdAt: Instant (작성일시)
 * - updatedAt: Instant (수정일시)
 */

@Getter
public class Post implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;
    private final UUID id;
    private String title;
    private String content;
    private UUID authorId;
    private List<String> tags;
    private final Instant createdAt;
    private Instant updatedAt;

    public Post(String title, String content, UUID authorId, List<String> tags) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.tags = tags;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }



}
