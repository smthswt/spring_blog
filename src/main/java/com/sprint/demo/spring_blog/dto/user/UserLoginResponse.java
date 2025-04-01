package com.sprint.demo.spring_blog.dto.user;

public record UserLoginResponse(
        boolean success,
        String token,
        String message
) {
}
