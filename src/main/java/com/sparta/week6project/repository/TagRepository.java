package com.sparta.week6project.repository;

import com.sparta.week6project.model.Tag;
import com.sparta.week6project.repository.mapping.PostMapping;
import com.sparta.week6project.repository.mapping.TagMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {
    List<TagMapping> findAllByPostId(Long id);

    void deleteAllByPostId(Long postId);

    List<PostMapping> findAllByTag(String tag);
}
