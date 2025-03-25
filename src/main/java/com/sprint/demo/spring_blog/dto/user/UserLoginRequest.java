package com.sprint.demo.spring_blog.dto.user;

public record UserLoginRequest(
        String id,
        String password
) {
}
