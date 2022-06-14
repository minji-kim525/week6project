package com.sparta.week6project.controller;


import com.sparta.week6project.dto.responseDto.HeartsResponseDto;
import com.sparta.week6project.security.UserDetailsImpl;
import com.sparta.week6project.service.HeartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HeartController {
        private final HeartService heartService;
        // isheart값 반전
        @PostMapping("/posts/heart/{postId}")
        public ResponseEntity<HeartsResponseDto> heartClick(@PathVariable Long postId , UserDetailsImpl userDetails) {
            // 로그인 한 사용자인지 아닌지 확인하기 ? 다음줄 : 로그인이 필요합니다 exception

            // 로그인한 사용자면 서비스로 가서 처리
            return ResponseEntity.ok().body(heartService.update(postId, userDetails));
        }
}
