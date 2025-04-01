package com.sprint.demo.spring_blog.dto.user;

import com.sprint.demo.spring_blog.entity.User;

import java.util.List;

public record UserListResponse(
        List<UserList> userList
) {
}
