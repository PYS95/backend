package com.okestro.board.service;

import com.okestro.board.model.CommentDto;

import java.util.List;

public interface CommentService {

        List<CommentDto> getCommentsByPost(Long postId);

        void registerComment(CommentDto commentDto);

        boolean deleteComment(Long commentId);
}
