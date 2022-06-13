package com.sparta.week6project.repository;

import com.sparta.week6project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long> {

    Optional<User> findByUsername(String username);
    Optional<User> findByNickname(String nickname);
    Optional<User> findByEmail(String email);
    Boolean existsByUsername(String username);
    Boolean existsByNickname(String nickname);
    Boolean existsByEmail(String email);
}
