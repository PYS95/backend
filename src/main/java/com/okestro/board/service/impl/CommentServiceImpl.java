package com.okestro.board.service.impl;

import com.okestro.board.model.CommentDto;
import com.okestro.board.model.entity.CommentEntity;
import com.okestro.board.service.CommentService;
import com.okestro.board.model.repo.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    // 댓글 불러오기
    @Override
    public CommentDto getComment(Long commentId) {
        Optional<CommentEntity> optionalCommentEntity = commentRepository.findById(commentId);
        if (optionalCommentEntity.isPresent()) {
            CommentEntity commentEntity = optionalCommentEntity.get();
            CommentDto commentDto = new CommentDto();
            commentDto.setComment_no(commentEntity.getComment_no());
            commentDto.setPost_no(commentEntity.getPost_no());
            commentDto.setUser_id(commentEntity.getUser_id());
            commentDto.setComment_content(commentEntity.getComment_content());
            return commentDto;
        }
        return null;
    }

    // 댓글 등록
    @Override
    public void registerComment(CommentDto commentDto) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setComment_no(commentDto.getComment_no());
        commentEntity.setPost_no(commentDto.getPost_no());
        commentEntity.setUser_id(commentDto.getUser_id());
        commentEntity.setComment_content(commentDto.getComment_content());
        commentRepository.save(commentEntity);
    }

    // 댓글 삭제
    @Override
    public boolean deleteComment(Long commentId) {
        Optional<CommentEntity> optionalCommentEntity = commentRepository.findById(commentId);
        if (optionalCommentEntity.isPresent()) {
            commentRepository.delete(optionalCommentEntity.get());
            return true;
        }
        return false;
    }
}
