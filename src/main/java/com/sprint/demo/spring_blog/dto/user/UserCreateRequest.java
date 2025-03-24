package com.sprint.demo.spring_blog.dto.user;

public record UserCreateRequest(
        String id,
        String password,
        String email,
        String nickname
) {
}
