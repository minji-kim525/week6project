package com.sparta.week6project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity createComment(@PathVariable Long postId, @RequestBody CommentRequestDto requestDto) {
        commentService.create(postId, requestDto);
        return ResponseEntity;
    }

    @GetMapping("/posts/{postId}/comments")
    public List<CommentResponseDto> readComment(@PathVariable Long postId) {
        commentService.read(postId);
        return commentResponseDto
    }
}