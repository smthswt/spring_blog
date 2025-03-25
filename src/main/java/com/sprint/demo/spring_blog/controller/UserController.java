package com.sprint.demo.spring_blog.controller;

import com.sprint.demo.spring_blog.dto.user.UserCreateRequest;
import com.sprint.demo.spring_blog.dto.user.UserCreateResponse;
import com.sprint.demo.spring_blog.entity.User;
import com.sprint.demo.spring_blog.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create
    @PostMapping
    public ResponseEntity<UserCreateResponse> createUser(@RequestBody UserCreateRequest request) {
        System.out.println("회원가입 API 요청 들어옴.");
        return ResponseEntity.ok(userService.register(request));
    }

}
