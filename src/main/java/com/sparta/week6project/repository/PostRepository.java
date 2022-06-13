package com.sparta.week6project.repository;

import com.sparta.week6project.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByModifiedAtDesc();

    Post findByIdAndUserId(Long postId, Long userId);

    Boolean existsByIdAndUserId(Long postId, Long userId);

    List<Post> findAllByUserIdOrderByModifiedAtDesc(Long userId);
}
