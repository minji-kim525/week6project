package com.sparta.week6project.repository;

import com.sparta.week6project.model.Heart;
import com.sparta.week6project.repository.mapping.PostMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HeartRepository extends JpaRepository<Heart, Long> {

    Optional<Heart> findByUser_IdAndPost_Id(Long userId, Long postId);

    Heart findByPostIdAndUserId(Long id, Long userId);

    void deleteAllByPostId(Long postId);

    Long countByPostIdAndIsheartTrue(Long id);

    List<PostMapping> findAllByUserIdAndIsheartTrue(Long userId);
}
