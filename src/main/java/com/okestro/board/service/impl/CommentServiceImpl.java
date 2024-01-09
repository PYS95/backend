package com.okestro.board.service.impl;

import com.okestro.board.model.CommentDto;
import com.okestro.board.model.entity.CommentEntity;
import com.okestro.board.model.entity.PostEntity;
import com.okestro.board.model.repo.CommentRepository;
import com.okestro.board.model.repo.PostRepository;
import com.okestro.board.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    // 댓글 불러오기
    @Override
    public CommentDto getComment(Long commentId) {
        Optional<CommentEntity> optionalCommentEntity = commentRepository.findById(commentId);
        if (optionalCommentEntity.isPresent()) {
            CommentEntity commentEntity = optionalCommentEntity.get();
            CommentDto commentDto = new CommentDto();
            commentDto.setComment_no(commentEntity.getComment_no());
            // 수정된 부분: commentEntity.getPost().getPost_no()로 변경
            commentDto.setPost_no(commentEntity.getPost().getPost_no());
            commentDto.setUser_id(commentEntity.getUser_id());
            commentDto.setComment_content(commentEntity.getComment_content());
            return commentDto;
        }
        return null;
    }

    // 댓글 등록
    @Override
    @Transactional
    public void registerComment(CommentDto commentDto) {
        Long commentPostNo = commentDto.getPost_no();

        if (commentPostNo == null) {
            System.out.println("post_no는 null일 수 없습니다.");
            // post_no가 null 일 때 처리, 예를 들어 오류 응답을 반환하거나 예외를 throw할 수 있습니다.
            return;
        }

        Optional<PostEntity> postEntityOptional = postRepository.findById(commentPostNo);
        if (postEntityOptional.isPresent()) {
            PostEntity postEntity = postEntityOptional.get();

            CommentEntity commentEntity = new CommentEntity();
            // 수정된 부분: commentEntity.setPost(postEntity)로 변경
            commentEntity.setPost(postEntity);
            commentEntity.setUser_id(commentDto.getUser_id());
            commentEntity.setComment_content(commentDto.getComment_content());
            commentRepository.save(commentEntity);
        } else {
            System.out.println("post_no에 대한 게시물을 찾을 수 없습니다: " + commentDto.getPost_no());
            // 연관된 게시물을 찾을 수 없는 경우 처리, 예를 들어 오류 응답을 반환하거나 예외를 throw할 수 있습니다.
        }
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
