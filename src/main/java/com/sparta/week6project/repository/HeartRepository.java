package com.sparta.week6project.repository;

import com.sparta.week6project.model.Heart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HeartRepository extends JpaRepository <Heart, Long>{
    Optional<Heart> findAllByUser_IdAndPost_Id(Long userId, Long postId);
}
