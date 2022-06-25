package com.sparta.week6project.controller;

import com.sparta.week6project.dto.requestDto.PagesRequestDto;
import com.sparta.week6project.dto.requestDto.PostRequestDto;
import com.sparta.week6project.dto.requestDto.TagRequestDto;
import com.sparta.week6project.dto.responseDto.PostResponseDto;
import com.sparta.week6project.security.UserDetailsImpl;
import com.sparta.week6project.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }


    // 게시글 조회
    @GetMapping("/posts/post/{postId}")
    public ResponseEntity<PostResponseDto> getPost(@PathVariable Long postId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseEntity.ok().body(postService.getPost(postId, isLogin(userDetails)));
    }


    // 게시글 전체 조회
    @GetMapping("/posts")
    public ResponseEntity<List<PostResponseDto>> getPosts(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseEntity.ok().body(postService.getPosts(isLogin(userDetails)));
    }


    // Infinite Scrolling Pagination
    // 조회 기능에 적용전
    @GetMapping("/posts/pagination")
    public ResponseEntity<List<PostResponseDto>> getPostsPages(@RequestBody PagesRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseEntity.ok().body(postService.getPostsPages(isLogin(userDetails), requestDto));
    }


    // 작성글 전체 조회
    @GetMapping("/posts/myposts")
    public ResponseEntity<List<PostResponseDto>> getMyposts(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseEntity.ok().body(postService.getMyPosts(isLogin(userDetails)));
    }


    // 좋아요한 게시글 전체 조회
    @GetMapping("/posts/heart")
    public ResponseEntity<List<PostResponseDto>> getLiedPosts(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseEntity.ok().body(postService.getLikedPosts(isLogin(userDetails)));
    }


    // 같은 종류 태그 전체 조회
    @GetMapping("/posts/tag")
    public ResponseEntity<List<PostResponseDto>> getTaggedPosts(@RequestBody TagRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseEntity.ok().body(postService.getTaggedPosts(isLogin(userDetails), requestDto));
    }


    // ================================ 조회 컨트롤러 종료 ===============================


    // 게시글 작성
    @PostMapping("/posts/post")
    public ResponseEntity<Void> createPost(
            @RequestPart(value = "postDto") PostRequestDto requestDto,
            @RequestPart(value = "file") MultipartFile file,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        postService.createPost(userDetails.getUser().getId(), requestDto, file);
        return ResponseEntity.ok().build();
    }


    // 게시글 수정
    @PutMapping("/posts/post/{postId}")
    public ResponseEntity<Void> updatePost2(
            @RequestPart(value = "postDto") PostRequestDto requestDto,
            @RequestPart(value = "file") MultipartFile file,
            @PathVariable Long postId,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        postService.updatePost(postId, userDetails.getUser().getId(), requestDto, file);
        return ResponseEntity.ok().build();
    }


    // 게시글 삭제
    @DeleteMapping("/posts/post/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        postService.deletePost(postId, userDetails.getUser().getId());
        return ResponseEntity.ok().build();
    }



    // 로그인 확인
    private Long isLogin(UserDetailsImpl userDetails){
        if(userDetails == null)return 0L;
        return userDetails.getUser().getId();
    }


}
