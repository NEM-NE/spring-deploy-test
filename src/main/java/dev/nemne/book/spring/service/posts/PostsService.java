package dev.nemne.book.spring.service.posts;

import dev.nemne.book.spring.domain.posts.Posts;
import dev.nemne.book.spring.domain.posts.PostsRepository;
import dev.nemne.book.spring.web.dto.PostsListResponseDto;
import dev.nemne.book.spring.web.dto.PostsResponseDto;
import dev.nemne.book.spring.web.dto.PostsSaveRequestDto;
import dev.nemne.book.spring.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor // final이 붙은 필드, @NonNull이 붙은 필드에 대해 생성자를 생성, 주로 DI에 사용
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts post = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        post.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts post = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        return new PostsResponseDto(post);
    }

    @Transactional(readOnly = true) // 트랜잭션 범위는 유지하되, 조회기능만 남겨 조회속도가 개선
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        Posts post = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        postsRepository.delete(post);
    }
}
