package com.sparta.week6project.repository;

import com.sparta.week6project.model.Heart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeartRepository extends JpaRepository<Heart, Long> {

    boolean existsByPostIdAndUserId(Long id, Long userId);

    Long countByPostId(Long id);
}
