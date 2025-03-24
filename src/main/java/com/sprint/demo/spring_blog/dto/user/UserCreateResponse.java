package com.sprint.demo.spring_blog.dto.user;

public record UserCreateResponse(
        String id,
        String email,
        String nickname
) {
}
