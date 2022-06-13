package com.sparta.week6project.service;


import com.sparta.week6project.dto.responseDto.HeartsResponseDto;
import com.sparta.week6project.model.Heart;
import com.sparta.week6project.model.Post;
import com.sparta.week6project.model.User;
import com.sparta.week6project.repository.HeartRepository;
import com.sparta.week6project.repository.PostRepository;
import com.sparta.week6project.repository.UserRepository;
import com.sparta.week6project.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HeartService {
    private final HeartRepository heartRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    // isheart값 반전시켜주기
    @Transactional
    public HeartsResponseDto update(Long postId, UserDetailsImpl userDetails) {

        Long userId = userDetails.getUser().getId();
        Boolean tf;
        // 로그인한 사용자면 레포지토리에서 찾아오자 heart 테이블을
        Optional<Heart> heart = heartRepository.findByUser_IdAndPost_Id(postId, userId);
        if (heart.isPresent()) {
            // 해당 행이 있으면 Isheart값 변경
            heart.get().setIsheart();
            tf = heart.get().getIsheart();
        }
        else {
            // 처음 좋아요를 누르는 것이라면 생성하기위한 Post, User 가져오기기
           Post post = postRepository.findById(postId).orElseThrow(
                    () -> new NullPointerException("해당 게시글이 존재하지 않습니다.")
            );
            User user = userRepository.findById(userId).orElseThrow(
                    () -> new NullPointerException("해당 유저가 존재하지 않습니다.")
            );
            Heart hearts = new Heart(post, user);
            heartRepository.save(hearts);
            tf = hearts.getIsheart();
        }
        return new HeartsResponseDto(tf);
    }
}
