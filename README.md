# 미니 프로젝트 7조 회고

# 🏖️ Licxel

---

- 소중한 일상의 순간을 공유하는 사이트

**목표**

- 파일 업로드 기능, CRUD
- front-end와 back-end의 협업을 통한 서버와 클라이언트 연결의 전체적인 흐름 파악, 의사소통 방법

---

## 👥 **1. 제작 기간 & 팀원 소개 - 블로그주소, 이메일주소 확인하기**

- 2022년 06월 09일 ~ 2022년 06월 16일
- 5인 1조 팀 프로젝트

| 이름 | 블로그 주소 | 이메일 주소 | 포지션 | 
| --- | --- | --- | --- |
| 김창규 | https://copy1.tistory.com/ | kimchangkyu99@gmail.com | Back-End |
| 김민수 | https://real-coding.tistory.com/ | manager.kim86@gmail.com | Back-End | 
| 김민지 | https://velog.io/@alswlwkd20 | alswlrkwkddldi@gmail.com | Back-End |
| 이담 | https://velog.io/@ddam_iiya | ddam2lee@gmail.com | Front-End |
| 이민석 | https://velog.io/@lee222 | cube9072@naver.com | Front-End | 

> 조원 / 각자 역할 및 구현 기능
> 
> 
> > 김창규
> > 
> > - 댓글 작성 및 조회
> > - Exception handling
> > - 서버 배포
> 
> > 김민수
> > 
> > - 게시글 CRUD
> > - Tag, 좋아요, 내가 작성한 글 전체 검색 조회
> 
> > 김민지
> > 
> > - 회원가입, 로그인, Security 설정
> > - CORS 설정
> > - Validation handling
> 
> > 이담
> > 
> > - 작업 구조, 경로 설계
> > - 메인 페이지
> > - 액세스 토큰 관리
> > - 게시물 상세 페이지, 게시물 삭제 기능
> 
> > 이민석
> > 
> > - 로그인 회원가입 기능
> > - 게시글 작성, 수정 기능
> > - 메인 페이지 게시물 조회 기능

---

## 🔨 **2. 사용 기술 및 툴**

`Back-end` `Spring boot`

- Spring Security
- Jwt
- Amazon S3
- Bean Validation
- Lombok
- Spring Web
- Spring Data JPA
- H2 Database
- MySql Driver

`Front-end` `React`

- Html
- Css
- Javascript
- React
- react-redux
- reduxjs/toolkit
- Jquery
- Axios

`deploy`

- Amazon EC2

---

## 🖇️ **3.** Licxel **링크**

<aside>
🔗 [http://c-7mini.s3-website.ap-northeast-2.amazonaws.com](http://c-7mini.s3-website.ap-northeast-2.amazonaws.com/Login)

</aside>

---

## 🖇️ **4. S.A (Starting Assignment)**

<aside>
🔗 [https://marked-mulberry-d63.notion.site/7-c0e9e91154914e6e96b569340e6ec5ec](https://www.notion.so/7-SA-c0e9e91154914e6e96b569340e6ec5ec)

</aside>

---

## 🖇️ **5. 실행화면 유튜브 링크**

<aside>
🔗 [https://www.youtube.com/watch?v=jgQQySlMm5M](https://www.youtube.com/watch?v=jgQQySlMm5M)

</aside>

---

## 💯 **6. 핵심기능**

- 회원가입, 로그인 & 로그아웃
    - JWT를 사용
    - 회원가입 시 user db를 조회, 중복체크
    
- 메인페이지
    - 게시글 작성, 조회, 수정, 삭제
        - 게시글 작성, 수정, 삭제는 권한이 있어야 접근 가능
        - 파일 업로드
        - 게시글 조회 시 로그인 유무에 따라 좋아요 상태 반영
    - 댓글  작성, 조회, 삭제
        - User 정보가 있어야 접근 가능
    - 좋아요, 태그 기능
        - 내가 좋아요 한 글만 조회, 특정 태그 조회
    

---

## 🎮 **7. Trouble shooting**

> CORS 연결
> 
> 
> > 이슈 내용 : Header에는  token값이 들어오지만 Response 콘솔에는 udefined가 찍히는 이슈
> > 
> 
> > 해결 방법 : 헤더에 접근을 못해서 생긴문제로, cors 설정에 `.exposedHeaders(Authorization)` 를 추가하여 헤더값 접근 허용
> > 

> 파일 업로드
> 
> 
> > 이슈 내용 :  Form-data 형식으로 JSON 데이터와 MultipartFile 한번에 전송할때 이슈 발생
> > 
> 
> > 해결 방법 :  JSON 데이터 전달시 실제로는 문자열로 인코딩 되어 전달되기 때문에 application/json으로 content type을 별도로 명기해주어야 전송 가능
> > 
> 
> 게시글 삭제
> 
> > 이슈 내용 :  DB에 저장되어 있는 게시글 삭제 시 SqlException 발생
> > 
> 
> > 해결 방법 :  게시글 삭제시 해당 글을 참조하고 있는 하위 데이터들을 먼저 삭제하여 연관관계를 제거 후 삭제 하여야 가능
> > 
> 
> 게시글 조회 - FE
> 
> > 이슈 내용: DB에서 GET요청 후 response로 받아오는 데이터들을 상태관리를 하는데 장애 발생
> > 
> 
> > 해결 방법: extraReducer를 사용하여 pending fulfiled rejected로 요청 상태에따른 값을 개별로 할당시켜 관리 => 장애 해결 및 클라이언트에서 상태 확인 용이하게 개편.
> > 
> 
> Git Merge Conflict
> 
> > 이슈 내용: Conflict에러로 인한 저장소 공유 불가
> > 
> 
> > 해결 방법: 아직..
> > 

---

## ⚙️ **8. 필수 기능 코드 리뷰**

- API
    
    ```java
    // UserController
    @PostMapping("/user/signup")  // 회원 가입
    @PostMapping("/user/login")  // 로그인
    @PostMapping("/user/signup/duplicate")  // 중복 확인
    
    // PostController
    @GetMapping("/posts/post/{postId}")  // 게시글 조회
    @GetMapping("/posts")  // 게시글 전체 조회
    @GetMapping("/posts/myposts")  // 작성글 전체 조회
    @GetMapping("/posts/heart")  // 좋아요한 게시글 전체 조회
    @GetMapping("/posts/tag")  // 같은 종류 태그 전체 조회
    @PostMapping("/posts/post")  // 게시글 작성
    @PutMapping("/posts/post/{postId}")  // 게시글 수정
    @DeleteMapping("/posts/post/{postId}")  // 게시글 삭제
    
    // CommentController
    @PostMapping("/posts/{postId}/comments")  // 댓글 작성
    @GetMapping("/posts/{postId}/comments")  // 댓글 조회
    @DeleteMapping("/posts/comments/{commentId}")  // 댓글 삭제
    
    // HeartController
    @PostMapping("/posts/heart/{postId}")  // 좋아요 상태 변경
    ```
    
- 회원가입
    
    ```java
    //Controller
    @PostMapping("/user/signup")
    public ResponseEntity<SignUpResponseDto> registerUser(@Valid @RequestBody SignUpRequestDto signUpRequestDto){
         return ResponseEntity.ok().body(userService.registerUser(signUpRequestDto));
    }
    
    //Dto 유효성 검사
    public class SignUpRequestDto {
        @NotNull(message = "아이디를 입력해주세요")
        @Pattern(regexp = "^[a-z][a-z0-9]{5,11}$",message = "아이디 형식이 올바르지 않습니다.")
        private String username;
    
        @NotNull
        @Pattern(regexp = "^(?=.*[a-zA-Z])((?=.*\\d)(?=.*\\W)).{8,16}$", message = "비밀번호 형식이 올바르지 않습니다.")
        private String password;
    
        @NotNull
        private String passwordCheck;
        private String profileImage;
    
        // @Email은 null 허용, 빈문자열 "" true , 공백" " false
        private String email;
    
        @NotNull
        @NotBlank
        @Length(min=2,max=10,message="닉네임 형식이 올바르지 않습니다.")
        private String nickname;
    }
    
    //validation exceptino handler
    //MethodArgumentNotValidException에서 BindingResult를 사용할 수 있는데,
    //BindingResult에는 Validaiton에서 걸린 변수의 message를 확인 가능
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Object> validException(MethodArgumentNotValidException e) {
           ErrorResponseDto ResponseException = new ErrorResponseDto(false, e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return ResponseEntity.badRequest().body(ResponseException);
        }
    
    //Service
    public SignUpResponseDto registerUser(SignUpRequestDto signUpRequestDto) {
            if(signUpRequestDto.getEmail()!=null) {
                Optional<User> foundUsername = userRepository.findByUsername(signUpRequestDto.getUsername());
                Optional<User> foundNickname = userRepository.findByNickname(signUpRequestDto.getNickname());
                Optional<User> foundEmail = userRepository.findByEmail(signUpRequestDto.getEmail());
    
                try {
                    //중복 체크
                    UserValidator.idDuplicationValidator(foundUsername);
                    UserValidator.nicknameDuplicationValidator(foundNickname);
                    UserValidator.emailDuplicationValidator(foundEmail);
                    UserValidator.emailCheackValidator(signUpRequestDto);
                    //패스워드 일치 체크
                    UserValidator.passwordCheackValidator(signUpRequestDto);
    
                } catch (IllegalArgumentException e) {
                    throw e;
                }
            }else {
                Optional<User> foundUsername = userRepository.findByUsername(signUpRequestDto.getUsername());
                Optional<User> foundNickname = userRepository.findByNickname(signUpRequestDto.getNickname());
                try {
                    UserValidator.idDuplicationValidator(foundUsername);
                    UserValidator.nicknameDuplicationValidator(foundNickname);
                    UserValidator.passwordCheackValidator(signUpRequestDto);
    
                } catch (IllegalArgumentException e) {
                    throw e;
                }
            }
            signUpRequestDto.setPassword(passwordEncoder.encode(signUpRequestDto.getPassword()));
            User user = new User(signUpRequestDto);
            userRepository.save(user);
            return new SignUpResponseDto(true, "회원가입 성공");
        }
    
    ```
    
- 게시글 작성
    
    ```java
    // Controller
    @PostMapping("/posts/post")
    public ResponseEntity<Void> createPost(
            @RequestPart(value = "postDto") PostRequestDto requestDto,  // 문자열 데이터와 file 데이터를 한번에 전송하기 위해 Form-data형식 사용
            @RequestPart(value = "file") MultipartFile file,
            @AuthenticationPrincipal UserDetailsImpl userDetails) { // 로그인한 유저 정보 불러오기
        postService.createPost(userDetails.getUser().getId(), requestDto, file);
        return ResponseEntity.ok().build();
    }
    
    // Service
    public void createPost(Long userId, PostRequestDto requestDto, MultipartFile file) {
        User user = userRepository.findById(userId).orElseThrow(  // 회원 정보 확인
                ()-> new IllegalArgumentException("등록되지 않은 사용자입니다.")
        );
    
        if(file.isEmpty()){  // 파일 업로드 유무 확인 (null 허용됨)
            requestDto.setImageUrl(null);
            requestDto.setFileName(null);
        } else {
            requestDto.setImageUrlAndFileName(s3Service.upload(file));  // 업로드 파일 저장 및 Url Mapping 작업용 Service 호출 (아래 S3Service로 이동)
        }
    
        Post post = postRepository.save(new Post(user, requestDto));  // 게시물 DB 저장
        if(!requestDto.getTags().isEmpty()) {  
            for(TagRequestDto tagRequestDto : requestDto.getTags()){
                tagRepository.save(new Tag(post, tagRequestDto));  // 태그 DB 저장
            }
        }
    }
    
    // S3Service : 업로드 파일 저장 및 Url Mapping용 
    private AmazonS3Client s3Client;
    
        @Value("${iamAccessKey}")
        private String accessKey;  // 민감 정보 properties 파일에 숨겨서 사용
        @Value("${iamSecretKey}")
        private String secretKey;  // 민감 정보 properties 파일에 숨겨서 사용  
        private final String region = "ap-northeast-2";  // 서버 지역
        private final String bucket = "team7-bucket";  // 서버명
        @PostConstruct
        public void setS3Client() {
            AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
    
            s3Client = (AmazonS3Client) AmazonS3ClientBuilder.standard()
                    .withCredentials(new AWSStaticCredentialsProvider(credentials))
                    .withRegion(this.region)
                    .build();
        }
    
    public FileRequestDto upload(MultipartFile file) {
        String fileName = createFileName(file.getOriginalFilename()); // 파일명 난수로 변경
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(file.getSize());          // 파일 크기
        objectMetadata.setContentType(file.getContentType());     // 파일 타입
    
        try(InputStream inputStream = file.getInputStream()) {
            s3Client.putObject(new PutObjectRequest(bucket,fileName,inputStream,objectMetadata)  
                    .withCannedAcl(CannedAccessControlList.PublicRead));
            return new FileRequestDto(s3Client.getUrl(bucket, fileName).toString(), fileName);  // Url값 반환 (위의 Service로 다시 이동)
        }catch (IOException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"파일 업로드에 실패하셨습니다");
        }
    }
    
    // S3Service : 파일명 난수로 변경
    private String createFileName(String fileName) {
        return UUID.randomUUID().toString().concat(getFileExtension(fileName));
    }
    
    // S3Service : 파일 유효성 검사
    private String getFileExtension(String fileName) {
        try {
            return fileName.substring(fileName.lastIndexOf("."));
        } catch (StringIndexOutOfBoundsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "잘못된 형식의 파일(" + fileName + ") 입니다.");
        }
    }
    ```
    
- 예외처리
    
    ```java
    // Controller
    @DeleteMapping("/posts/comments/{commentId}")
        public ResponseEntity<Void> removeComment(@PathVariable("commentId") Long commentId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
            commentService.removeComment(commentId,userDetails);
            return ResponseEntity.ok().build();
        }
    // Service
    public void removeComment(Long commentId,UserDetailsImpl userDetails) {
            // 있는 댓글인지 확인
            Comment comment = commentRepository.findById(commentId).orElseThrow(
                    () -> new NullPointerException("해당 댓글이 존재하지 않습니다")               // 예외를 생성하고 Throw한다 removeComment()를 사용한 Controller에게 
            );
            // 로그인한 사용자 != 댓글 작성자
            if (!comment.getUser().getId().equals(userDetails.getUser().getId())) {
                throw new IllegalArgumentException("사용자 정보가 달라 삭제할 수 없습니다");
            }
            commentRepository.deleteById(commentId);
        }
    // Exception
    @RestControllerAdvice                        // 모든 Controller에서 발생한 예외를 처리할 수 있는곳
    public class RestApiExceptionHandler {
        @ExceptionHandler(value = {              // value에 적혀있는 종류의 예외를 잡아다 처리해준다.
                IllegalArgumentException.class,
                NullPointerException.class,
                ResponseStatusException.class} )
        public ResponseEntity<Object> handlerControllerException (Exception e) {
            return ResponseEntity.badRequest().body(new ErrorResponseDto(false, e.getMessage())); 
        }
    ```
    

---

## 💏 9**. 7조 한주 회고**

> 화면을 구성할 때 중요한 와이어프레임을 성의없이 작성하고 제출했다. 그 모습대로 작업을 하려니 당연히 어려웠을거같다. 생각해보면 무엇을 정할 때 내가 작업 할 백엔드 기준으로 맞춰달라고 프론트에 요구를 했다. 그래서 API를 설계하는 과정에서 Request와 Response를 어느쪽이 주체를 가지고 정해야 하는지 알게되었다. Gitgub를 처음으로 프로젝트에 적용해서 진행해는데 처음에는 어려웠지만 익숙해지니 편했다. 이번에는 기능구현보다는 팀원들이 짠 코드를 보고 배우는 시간이었다. 그리고 나는 생각없이 코드를 짜고 오류가 나지 않는 이상 내 코드를 자세히 보지 않았었다.  그러다 다른 팀원들의 코드를 보고 다시 내 코드를 보니 문제가 많아 교정하는데 도움이 정말 많이 되었다. 아쉬웠다. 팀장의 역할을 하지 못해서. 아쉬웠다. 주도적으로 이끌어가지 못하고 정해지면 따라가는 사람이어서.  마지막으로 고생하신 팀원 모두 수고하셨습니다. ***- 김창규***
> 

> Front-End와 Back-End로 나눠서 하는 첫 프로젝트였던 만큼 많은 이슈가 있었던거 같다. 지금은 팀 동료들의 노력으로 많이 개선되었지만 처음 팀이 만들어 졌을때 서로가 사용하는 용어가 달라 소통에 어려움이 많았다. 기능 구현부터 테스트까지 혼자서 진행해 왔던 지난주 주특기 과정까지와는 다르게 이제는 내가 작성한 코드와 팀원들이 작성한 코드들이 잘 연결되어 작동 되는지를 확인하고 문제 발생시 함께 해결하여야 했다. 그러다 보니 자연스레 소통의 시간이 늘어났고 그로부터 많은 것을 배웠던거 같다. 특히나 매일 github를 통해 각자의 local repository 버전을 모두 같은 버전으로 통일 시킨 후 진행한 코드 리뷰는 팀원들이 공부한 내용을 습득할 수 있어 하루를 더 길게 보내는 효과가 있었던거 같다. 다만, 팀적으로는 만족스러운 한주였으나 개인적으로는 아직까직도 내가 작업하고 공부한 내용을 정리하는 습관이 부족한거 같아 더 노력을 해야될 듯 하다. 팀원 여러분 모두 수고하셨습니다! ***- 김민수***
> 

> 이번에 팀 프로젝트를 통해서 어떤식으로 협업을 해야하는지 조금 감이 잡혔고, git 관리에 전보다 더 익숙해진 것 같다. 팀원들과 코드 리뷰를 하면서 내가 놓쳤던 부분을 알 수 있었고, 더 효율적으로 코드를 짜기위한 팀원들의 고민의 흔적들이 곳곳에 보여서 많이 배웠다. 나의 부족했던 부분을 팀원 분들이 채워주셔서 든든했던 부분이 많은 것 같다. 또 프론트 엔드와 처음으로 같이 작업을 한 것인 만큼 연결 과정에서 많은 이슈들이 있었지만, 그 과정에서 의사소통하는 것과 이슈 해결하는 방법을 알게 된 것 같고, 이번 경험을 토대로 다음 프로젝트에는 나에게서 좀 더 좋은 모습을 찾을 수 있으면 좋겠다. 팀원 분들 모두 감사드리고 남은 두 번의 프로젝트 모두 화이팅 해봅시다! ***- 김민지***
> 

> 프로젝트의 목적도 중요하지만 전체의 그림을 잘 보고 가는 것이 중요하다는 생각이 든 한 주 였다. 당장의 기능 구현은 성공과 실패의 단순한 결과가 아니라 코드를 깊이 이해하는 탐구심과 통찰력에서 나온다는 걸 깨닫게 되었다. 백엔드 분들과의 협업이 처음에는 많이 조심스럽고 혹시나 모르고 실수하는 부분이 있을까봐 걱정했는데 우리 팀 분들은.. 정말 천사같았다. 모르는 부분을 지적하지 않고 많이 배워가야한다며 프론트엔드로서 많이 부족함에도 천천히 기다려주시고 이해가 어려운 부분은 함께 고민해주시고., 천천히 깊이 있게 공부해가는 태도가 얼마나 중요한지를 이번 주차에 많이 알게 되었다. 사실 지난 주차까지도 개발자를 어떻게 할 수 있을까 고민을 많이 했는데 몸이 고단하고 머리가 꽉찬 한주를 보내니 앞으로 더 잘 할 수 있을 것 같다는 생각이 든다. 결과물에 상관없이 많이 배웠다:) 감사합니다 팀원들!! ***-이담***
> 

> 이번 팀프로젝트를 통해 프론트와 백엔드의 협업 방식 뿐만 아니라, 프론트 구성원간의 소통과 협업방식 또한 중요하다고 느끼게 되었고, 어떤 방식으로 양쪽과 소통해야할지 깨닫게 되었다. 팀원과 서로의 코드를 공유해보며 틀린 부분을 수정하고 여러가지 방안을 제시하고 사용해보며 서로 해결하지 못했던 문제들을 같이 해결해가는 경험이 굉장히 좋은 기회였던 것 같다. 백엔드와의 소통은 초반 연결 단계에서만 하더라도 서로 사용하는 용어도 다르고 구현방식도 많이 달라, 어떻게 해야할지 감이 오지 않았지만, 마무리에 들어서는 어느정도 서로 소통도 원활히 되었던 것 같다. 본인의 참여시간 부족으로 인해 프론트에서 처음 기획했던 초안 기능들의 반도 못 구현하게 된 것 같아, 다른 팀원들에게 죄송한 마음이 든다. 팀원분들 다들 고생하신 것 같고 남은 기간동안 잘 해내실거라 믿는다. 
다들 화이팅하세요! ***- 이민석***
>
