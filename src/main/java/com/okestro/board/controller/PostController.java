package com.okestro.board.controller;

import com.okestro.board.model.PostDto;
import com.okestro.board.model.entity.PostEntity;
import com.okestro.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;

    // 목록 페이지
    @GetMapping("/list")
    public ResponseEntity<List<PostDto>> getPostList() {
        List<PostDto> postList = postService.getPostList();
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }

    // 상세 페이지
    @GetMapping("/{post_no}")
    public ResponseEntity<PostDto> getPost(@PathVariable Long post_no) {
        try {
            PostDto post = postService.getPost(post_no);
            return new ResponseEntity<>(post, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // 게시글 생성
    @PostMapping
    public ResponseEntity<PostEntity> createPost(@RequestBody PostDto postDto) {
        try {
            PostEntity createdPost = postService.createPost(postDto);
            return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 게시글 수정
    @PutMapping("/{post_no}")
    public ResponseEntity<PostEntity> updatePost(@PathVariable Long post_no, @RequestBody PostDto postDto) {
        try {
            PostEntity updatedPost = postService.updatePost(post_no, postDto);
            return new ResponseEntity<>(updatedPost, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 게시글 삭제
    @DeleteMapping("/{post_no}")
    public ResponseEntity<String> deletePost(@PathVariable Long post_no) {
        try {
            postService.deletePost(post_no);
            return new ResponseEntity<>("게시글이 성공적으로 삭제되었습니다.", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("게시글이 존재하지 않습니다.", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("게시글 삭제에 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
