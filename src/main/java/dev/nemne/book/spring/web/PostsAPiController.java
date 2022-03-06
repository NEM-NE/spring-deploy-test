package dev.nemne.book.spring.web;

import dev.nemne.book.spring.service.posts.PostsService;
import dev.nemne.book.spring.web.dto.PostsResponseDto;
import dev.nemne.book.spring.web.dto.PostsSaveRequestDto;
import dev.nemne.book.spring.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsAPiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestParam PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
}
