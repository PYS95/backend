package com.okestro.board.controller;

import com.okestro.board.model.PostDto;
import com.okestro.board.model.entity.PostEntity;
import com.okestro.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class PostController {

    private final PostService postService;

    // 목록 페이지
    @GetMapping("/board")
    public List<PostDto> getPostList() {
        return postService.getPostList();
    }

    // 상세 페이지
    @GetMapping("/board/{post_no}")
    public PostDto getPost(@PathVariable("post_no") Long post_no) {
        return postService.getPost(post_no);
    }

    // 게시글 생성
    @PostMapping("/board")
    public PostEntity createPost(@RequestBody PostDto postDto) {
        return postService.createPost(postDto);
    }

    // 게시글 수정
    @PatchMapping("/board/{post_no}")
    public PostEntity updatePost(@PathVariable("post_no") Long post_no, @RequestBody PostDto postDto) {
        return postService.updatePost(post_no, postDto);
    }

    // 게시글 삭제
    @DeleteMapping("/board/{post_no}")
    public void deletePost(@PathVariable("post_no") Long post_no) {
        postService.deletePost(post_no);
    }
}
