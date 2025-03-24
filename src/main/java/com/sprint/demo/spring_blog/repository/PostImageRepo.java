package com.sprint.demo.spring_blog.repository;

import com.sprint.demo.spring_blog.entity.PostImage;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PostImageRepo {
    PostImage savePostImage(UUID postId, UUID imageId);
    Optional<PostImage> findById(UUID id);
    Optional<PostImage> findByTitle(String title);
    List<PostImage> findAll();
    PostImage updatePostImage(PostImage postImage);
    void deletePostImage(UUID id);

}
