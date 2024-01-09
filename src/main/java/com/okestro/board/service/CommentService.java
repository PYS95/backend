package com.okestro.board.service;

import com.okestro.board.model.CommentDto;

public interface CommentService {

        CommentDto getComment(Long commentId);

        void registerComment(CommentDto commentDto);

        boolean deleteComment(Long commentId);

}
