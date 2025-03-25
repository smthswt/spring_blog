package com.sprint.demo.spring_blog.service.imp;

import com.sprint.demo.spring_blog.dto.user.*;
import com.sprint.demo.spring_blog.entity.User;
import com.sprint.demo.spring_blog.repository.file.FilePostRepo;
import com.sprint.demo.spring_blog.repository.file.FileUserRepo;
import com.sprint.demo.spring_blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final FileUserRepo fileUserRepo;
//    private final FilePostRepo filePostRepo;

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*";


    @Override
    public UserCreateResponse register(UserCreateRequest request) {
        //ID 중복 체크
        Optional<User> existingUser = fileUserRepo.findById(request.id());
        if (existingUser.isPresent()) {
            return new UserCreateResponse(false, "이미 사용 중인 ID입니다.");
        }

        // ID 길이 검사
        if (request.id().length() <= 6 || request.id().length() >= 30) {
            return new UserCreateResponse(false, "ID는 6자 이상 30자 이하여야 합니다.");
        }

        // 닉네임 길이 검사
        if (request.nickname().length() > 50) {
            return new UserCreateResponse(false, "닉네임은 50자 이하여야 합니다.");
        }

        // 이메일 형식 검사 + 100자 이하
        if (request.email().length() > 100 && !EMAIL_PATTERN.matcher(request.email()).matches()) {
            return new UserCreateResponse(false, "이메일 형식이 올바르지 않거나 최대 길이 100자를 초과했습니다.");
        }

        // 비밀번호 길이 검사
        String password = request.password();
        if (password.length() < 12 || password.length() > 50) {
            return new UserCreateResponse(false, "비밀번호는 12자 이상 50자 이하이어야 합니다.");
        }

        // 비밀번호 구성 검사 (영문/숫자/특수문자 각 2글자 이상)
        int letters = 0, digits = 0, specials = 0;
        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) letters++;
            else if (Character.isDigit(c)) digits++;
            else if (SPECIAL_CHARACTERS.indexOf(c) >= 0) specials++;
        }
        if (letters < 2 || digits < 2 || specials < 2) {
            return new UserCreateResponse(false, "비밀번호는 영문, 숫자, 특수문자(!@#$%^&*)를 각각 2자 이상 포함해야 합니다.");
        }

        User user = new User(request.id(), request.password(), request.email(), request.nickname());
        fileUserRepo.saveUser(user);

        return new UserCreateResponse(true, "회원 가입이 완료되었습니다.");
    }

    @Override
    public UserLoginResponse login(UserLoginRequest request) {
        return null;
    }

    @Override
    public UserListResponse findAll() {
        return null;
    }

    @Override
    public UserUpdateResponse edit(UserUpdateRequest request) {
        return null;
    }

    @Override
    public void delete(String userId) {

    }
}
