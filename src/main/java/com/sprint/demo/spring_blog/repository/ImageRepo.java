package com.sprint.demo.spring_blog.repository;

import com.sprint.demo.spring_blog.entity.Image;

import java.util.Optional;
import java.util.UUID;

public interface ImageRepo {
    Image saveImage(Image image);
    Optional<Image> findById(UUID id);
    void deleteImage(UUID id);
}
