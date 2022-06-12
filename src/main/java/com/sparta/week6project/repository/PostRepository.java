package com.sparta.week6project.repository;

import com.sparta.week6project.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
