package com.sparta.week6project.repository;

import com.sparta.week6project.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {
    List<Tag> findAllByPostId(Long id);

    void deleteAllByPostId(Long postId);
}
