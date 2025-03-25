package com.sprint.demo.spring_blog.service;

import com.sprint.demo.spring_blog.dto.user.*;
import com.sprint.demo.spring_blog.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    // 서비스 관점, 사용자 관점, DTO 활용(최소한의 정보만 노출하기)
    // create(회원가입), find(단일 조회/로그인), findAll(전체 명단 조회), update(사용자 정보 수정) , delete(탈퇴)
    UserCreateResponse register(UserCreateRequest request);
    UserLoginResponse login(UserLoginRequest request);
    UserListResponse findAll();
    UserUpdateResponse edit(UserUpdateRequest request);
    void delete(String userId);
}
