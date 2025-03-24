package com.sprint.demo.spring_blog.repository;

import com.sprint.demo.spring_blog.dto.user.UserCreateRequest;
import com.sprint.demo.spring_blog.dto.user.UserCreateResponse;
import com.sprint.demo.spring_blog.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepo {
    User saveUser(User user);
    Optional<User> findById(String id);
    Optional<User> findByEmail(String email);
    List<User> findAll();
//    String updateNickname(String id, String newNickname);
//    String updatePassword(String id, String password);
    User updateUser(User user);
    void deleteUser(String id, String password);

}
