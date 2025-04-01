package com.sprint.demo.spring_blog.repository.file;

import com.sprint.demo.spring_blog.entity.User;
import com.sprint.demo.spring_blog.repository.UserRepo;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class FileUserRepo implements UserRepo {
    private final Path DIRECTORY;
    private final String EXTENSION = ".ser";

    public FileUserRepo() {
        // 경로 설정(정의), repositoryToFile/{도메인 class명}
        this.DIRECTORY = Paths.get(System.getProperty("user.dir"), "repositoryToFile", User.class.getSimpleName());
        // 만약 경로가 없으면 위에 정의한 경로 생성(create), 없으면 스테이
        if (Files.notExists(DIRECTORY)) {
            try {
                Files.createDirectories(DIRECTORY);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Directory 새로운 경로 완성, id + 확장자
    private Path resolvePath(String id) {
        return DIRECTORY.resolve(id + EXTENSION);
    }

    @Override
    public User saveUser(User user) {
        Path path = resolvePath(user.getId());
        // fos, oos로 각 객체를 하나의 .ser 파일에 직렬화(이진 바이너리(바이트 단위로 표현된 데이터))해서 저장
        try (
                FileOutputStream fos = new FileOutputStream(path.toFile());
                ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            oos.writeObject(user);
        } catch (IOException e) {
            throw new RuntimeException("유저 파일 저장 실패: " + path, e);
        }
        return user;
    }

    @Override
    public Optional<User> findById(String id) {
        Path path = resolvePath(id);

        // 사용자 존재하지 않으면 Optional.empty() 반환
        if (Files.notExists(path)) {
            return Optional.empty();
        }

        try (
                FileInputStream fis = new FileInputStream(path.toFile());
                ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            User user = (User) ois.readObject();
            return Optional.of(user);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(String id, String password) {

    }
}
