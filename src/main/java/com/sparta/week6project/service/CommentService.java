package com.sparta.week6project.service;

import com.sparta.week6project.dto.requestDto.CommentRequestDto;
import com.sparta.week6project.dto.responseDto.CommentResponseDto;
import com.sparta.week6project.dto.responseDto.SignUpResponseDto;
import com.sparta.week6project.model.Comment;
import com.sparta.week6project.model.Post;
import com.sparta.week6project.model.User;
import com.sparta.week6project.repository.CommentRepository;
import com.sparta.week6project.repository.PostRepository;
import com.sparta.week6project.repository.UserRepository;
import com.sparta.week6project.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    // 댓글 생성
    public SignUpResponseDto createComment(Long postId, CommentRequestDto requestDto, UserDetailsImpl userDetails) {
        User user =userRepository.findById(userDetails.getUser().getId()).orElseThrow(
                ()-> new NullPointerException("해당 유저가 존재하지 않습니다.")
        );
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다.")
        );
        Comment comment = new Comment(post, requestDto, user);
        commentRepository.save(comment);
        return new SignUpResponseDto(true,"댓글이 작성되었습니다");
    }
    // 해당 게시글의 댓글 조회
    public List<CommentResponseDto> readComment(Long postId) {
        // 댓글들 중 게시글id가 넘어온 postId와 같은 값들을 (수정시간기준 내림차순으로) 가져온다.
        List<Comment> comments = commentRepository.findAllByPost_IdOrderByModifiedAtDesc(postId);
        // comment 작성자닉네임 , 수정시간, 댓글 내용
        List<CommentResponseDto> commentList = new ArrayList<>();
        if(!comments.isEmpty()) {
            for (int i=0; i<comments.size(); i++) {
                Long id = comments.get(i).getId();
                String name = comments.get(i).getUser().getNickname();
                String content = comments.get(i).getContent();
                LocalDateTime modifiedAt = comments.get(i).getModifiedAt();
                commentList.add(new CommentResponseDto(id, name, content, modifiedAt));
            }
        }
        return commentList;
    }
    // 댓글 삭제
    public void removeComment(Long commentId,UserDetailsImpl userDetails) {
        // 있는 댓글인지 확인
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new NullPointerException("해당 댓글이 존재하지 않습니다")
        );
        // 로그인한 사용자 != 댓글 작성자
        if (!comment.getUser().getId().equals(userDetails.getUser().getId())) {
            throw new IllegalArgumentException("사용자 정보가 달라 삭제할 수 없습니다");
        }
        commentRepository.deleteById(commentId);
    }
}
