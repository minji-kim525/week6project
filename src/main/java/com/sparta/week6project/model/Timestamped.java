package com.sparta.week6project.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Timestamped {      // 왜 추상화를 했는가?
    @JsonFormat(pattern ="YYYY-MM-DD")
    @CreatedDate
    private LocalDateTime createdAt;

    @JsonFormat(pattern ="YYYY-MM-DD")
    @LastModifiedDate
    private LocalDateTime modifiedAt;

}

