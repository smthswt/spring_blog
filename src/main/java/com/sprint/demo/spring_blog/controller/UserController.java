package com.sprint.demo.spring_blog.controller;

import com.sprint.demo.spring_blog.dto.user.UserCreateRequest;
import com.sprint.demo.spring_blog.dto.user.UserCreateResponse;
import com.sprint.demo.spring_blog.dto.user.UserLoginRequest;
import com.sprint.demo.spring_blog.dto.user.UserLoginResponse;
import com.sprint.demo.spring_blog.entity.User;
import com.sprint.demo.spring_blog.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create
    @PostMapping("/register")
    public ResponseEntity<UserCreateResponse> create(@RequestBody UserCreateRequest request) {
        System.out.println("회원가입 API 요청 들어옴.");
        return ResponseEntity.ok(userService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest request) {
        System.out.println("로그인 API 요청 들어옴.");
        return ResponseEntity.ok(userService.login(request));
    }


}
