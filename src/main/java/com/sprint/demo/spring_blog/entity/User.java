package com.sprint.demo.spring_blog.entity;

import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

/**
 * - id: String (사용자 ID) (+유효성 검증)
 * - password: String (암호화된 비밀번호)
 * - email: String (이메일)
 * - nickname: String (닉네임)
 * - createdAt: Instant (가입일시)
 */

@Getter
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String id;
    private String password;
    private String email;
    private String nickname;
    private final Instant createdAt;

    public User(String id, String password, String email, String nickname) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.createdAt = Instant.now();
    }
}
