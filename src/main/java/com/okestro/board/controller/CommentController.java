package com.okestro.board.controller;

import com.okestro.board.model.CommentDto;
import org.springframework.http.ResponseEntity;
import com.okestro.board.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{comment_id}")
    public ResponseEntity<CommentDto> getComment(@PathVariable Long comment_id) {
        CommentDto commentDto = commentService.getComment(comment_id);
        if (commentDto != null) {
            return new ResponseEntity<>(commentDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{comment_id}")
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
