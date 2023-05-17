package com.springboot_to_aws.web;

import com.springboot_to_aws.service.posts.PostService;
import com.springboot_to_aws.web.dto.PostsResponseDto;
import com.springboot_to_aws.web.dto.PostsSaveRequestDto;
import com.springboot_to_aws.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

//해당 API로 요청

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}") //게시글 수정
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/posts/{id}") //게시글 삭제
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }
}