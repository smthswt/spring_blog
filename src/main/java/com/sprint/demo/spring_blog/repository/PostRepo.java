package com.sprint.demo.spring_blog.repository;

import com.sprint.demo.spring_blog.entity.Post;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PostRepo {
    Post savePost(Post post);
    Optional<Post> findById(UUID id);
    Optional<Post> findByTitle(String title);
    List<Post> findAll();
    Post updatedPost(Post post);
    void deletePost(UUID id);
}
