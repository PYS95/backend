package com.okestro.board.controller;

import com.okestro.board.model.CommentDto;
import org.springframework.http.ResponseEntity;
import com.okestro.board.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/list/{postId}")
    public ResponseEntity<List<CommentDto>> getCommend(@PathVariable Long postId) {

        List<CommentDto> comments = commentService.getCommentsByPost(postId);
        if (comments != null && !comments.isEmpty()) {
            return new ResponseEntity<>(comments, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/add")
    public ResponseEntity<String> registerComment(@RequestBody CommentDto commentDto) {

        commentService.registerComment(commentDto);
        return new ResponseEntity<>("댓글이 성공적으로 등록되었습니다.", HttpStatus.OK);
    }

    @DeleteMapping("/{comment_id}")
    public ResponseEntity<String> deleteComment(@PathVariable Long comment_id) {
        if (commentService.deleteComment(comment_id)) {
            return new ResponseEntity<>("댓글이 성공적으로 삭제되었습니다.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("댓글 삭제에 실패했습니다.", HttpStatus.BAD_REQUEST);
        }
    }

}
