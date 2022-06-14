package com.sparta.week6project.controller;

import com.sparta.week6project.dto.requestDto.CommentRequestDto;
import com.sparta.week6project.dto.responseDto.CommentResponseDto;
import com.sparta.week6project.dto.responseDto.SignUpResponseDto;
import com.sparta.week6project.security.UserDetailsImpl;
import com.sparta.week6project.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    // 댓글 작성
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<SignUpResponseDto> createComment(@PathVariable Long postId, @RequestBody CommentRequestDto requestDto, UserDetailsImpl userDetails) {
        return ResponseEntity.ok().body(commentService.createComment(postId, requestDto, userDetails)); // 200, ok 가 가나?
    }
    // 댓글 조회
    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<List<CommentResponseDto>> readComment(@PathVariable Long postId) {
        return ResponseEntity.ok().body(commentService.readComment(postId));
    }
    // 댓글 삭제
    @DeleteMapping("/posts/comments/{commentId}")
    public ResponseEntity<Void> removeComment(@PathVariable("commentId") Long commentId, UserDetailsImpl userDetails) {
        // 로그인한 사용자인지 아닌지 구별하고 빠꾸먹이기?

        commentService.removeComment(commentId,userDetails);
        return ResponseEntity.ok().build();
    }
}