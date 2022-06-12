package com.sparta.week6project.repository;

import com.sparta.week6project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {
}
