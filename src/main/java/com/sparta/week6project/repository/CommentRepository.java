package com.sparta.week6project.repository;

import com.sparta.week6project.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPost_IdOrderByModifiedAtDesc(Long postId);
    //    countByPostIdAndIsheartTrue(Long postId)
}
