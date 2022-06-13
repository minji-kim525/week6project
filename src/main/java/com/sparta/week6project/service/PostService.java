package com.sparta.week6project.service;

import com.sparta.week6project.dto.requestDto.PostRequestDto;
import com.sparta.week6project.dto.requestDto.TagRequestDto;
import com.sparta.week6project.dto.responseDto.PostResponseDto;
import com.sparta.week6project.model.Heart;
import com.sparta.week6project.model.Post;
import com.sparta.week6project.model.Tag;
import com.sparta.week6project.model.User;
import com.sparta.week6project.repository.*;
import com.sparta.week6project.repository.mapping.PostMapping;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final TagRepository tagRepository;
    private final HeartRepository heartRepository;
    private final CommentRepository commentRepository;
    public PostService(
            PostRepository postRepository,
            UserRepository userRepository,
            TagRepository tagRepository,
            HeartRepository heartRepository,
            CommentRepository commentRepository){
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.tagRepository = tagRepository;
        this.heartRepository = heartRepository;
        this.commentRepository = commentRepository;
    }


    // 게시글 조회
    public PostResponseDto getPost(Long postId, Long userId) {
        Post post = postRepository.findById(postId).orElseThrow(
                ()-> new NullPointerException("해당 글을 찾을 수 없습니다.")
        );
        return postResMapping(post, userId);
    }


    // 게시글 전체 조회
    public List<PostResponseDto> getPosts(Long userId) {
        List<Post> posts = postRepository.findAllByOrderByModifiedAtDesc();
        return postListProcess(posts, userId);
    }


    // 작성글 전체 조회
    public List<PostResponseDto> getMyPosts(Long userId) {
        List<Post> posts = postRepository.findAllByUserIdOrderByModifiedAtDesc(userId);
        return postListProcess(posts, userId);
    }


    // 좋아요한 게시글 전체 조회
    public List<PostResponseDto> getLikedPosts(Long userId) {
        List<PostMapping> posts = heartRepository.findAllByUserIdAndIsheartTrue(userId); // 좋아요한 게시글 불러오기
        return postMappingListProcess(posts, userId);
    }


    // 같은 종류 태그 전체 조회
    public List<PostResponseDto> getTaggedPosts(Long userId, TagRequestDto requestDto) {
        List<PostMapping> posts = tagRepository.findAllByTag(requestDto.getTag());
        return postMappingListProcess(posts, userId);
    }


    // 리스트 조회용 middle process (Post 타입)
    private List<PostResponseDto> postListProcess(List<Post> posts, Long userId){
        List<PostResponseDto> postResponseDtos = new ArrayList<>();
        for(Post post : posts){
            postResponseDtos.add(postResMapping(post, userId));
        }
        return postResponseDtos;
    }


    // 리스트 조회용 middle process (PostMapping 타입)
    private List<PostResponseDto> postMappingListProcess(List<PostMapping> posts, Long userId){
        List<PostResponseDto> postResponseDtos = new ArrayList<>();
        for(PostMapping post : posts){
            postResponseDtos.add(postResMapping((Post) post, userId));
        }
        return postResponseDtos;
    }


    // 게시글 조회용 postResponsMapping process
    private PostResponseDto postResMapping(Post post, Long userId){
        Heart heart;
        if(userId == null){
            heart = null;
        } else {
            heart = heartRepository.findByPostIdAndUserId(post.getId(), userId);
        }

        return PostResponseDto.builder()
                .nickname(post.getUser().getNickname())
                .title(post.getTitle())
                .contents(post.getContent())
                .imageUrl(post.getImageUrl())
                .modifiedAt(post.getModifiedAt())
                .heart(heartRepository.countByPostIdAndIsheartTrue(post.getId()))
                .isHeart(heart != null && heart.getIsheart())
                .tags(tagRepository.findAllByPostId(post.getId()))
                .build();
    }


    // ================================ 조회 메서드 종료 ===============================


    // 게시글 작성
    public void createPost(Long userId, PostRequestDto requestDto) {
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new IllegalArgumentException("로그인이 필요합니다.")
        );

        Post post = postRepository.save(new Post(user, requestDto));
        for(TagRequestDto tagRequestDto : requestDto.getTags()){
            tagRepository.save(new Tag(post, tagRequestDto));
        }
    }


    // 게시글 수정
    @Transactional
    public void updatePost(Long postId, Long userId, PostRequestDto requestDto) {
        Post post = postRepository.findByIdAndUserId(postId, userId);
        if(post == null){
            throw new NullPointerException("존재하지 않는 글입니다.");
        }

        post.update(requestDto);

        tagRepository.deleteAllByPostId(postId);
        for(TagRequestDto tagRequestDto : requestDto.getTags()){
            tagRepository.save(new Tag(post, tagRequestDto));
        }

    }


    // 게시글 삭제
    @Transactional
    public void deletePost(Long postId, Long userId) {
        Boolean isPost = postRepository.existsByIdAndUserId(postId, userId);
        if(!isPost){
            throw new IllegalArgumentException("해당 글이 존재 하지 않거나 권한이 없습니다.");
        }

        // 게시글 삭제전 게시글 DB를 참조한 하위 데이터들 먼저 삭제
        tagRepository.deleteAllByPostId(postId);
        heartRepository.deleteAllByPostId(postId);
        commentRepository.deleteAllByPostId(postId);

        // 게시글 삭제
        postRepository.deleteById(postId);

    }


}
