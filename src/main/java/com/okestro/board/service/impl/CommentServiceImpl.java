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
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<CommentDto> getCommentsByPost(Long postId) {
        List<CommentEntity> commentEntities = commentRepository.findByPost_PostNo(postId);
        return commentEntities.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
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

    @Override
    public void updateCommentCount(Long postId) {
        // 댓글 수 업데이트 로직을 작성
        // 예시로 댓글 수를 가져와서 업데이트하는 방식으로 구현
        List<CommentEntity> comments = commentRepository.findByPost_PostNo(postId);
        int commentCount = comments.size();

        Optional<PostEntity> postEntityOptional = postRepository.findById(postId);
        if (postEntityOptional.isPresent()) {
            PostEntity postEntity = postEntityOptional.get();
            postEntity.setPost_comment_cnt(commentCount);
            postRepository.save(postEntity);
        } else {
            System.out.println("post_no에 대한 게시물을 찾을 수 없습니다: " + postId);
            // 연관된 게시물을 찾을 수 없는 경우 처리, 예를 들어 오류 응답을 반환하거나 예외를 throw할 수 있습니다.
        }
    }

    private CommentDto convertToDto(CommentEntity commentEntity) {
        CommentDto commentDto = new CommentDto();
        commentDto.setComment_no(commentEntity.getComment_no());
        commentDto.setPost_no(commentEntity.getPost().getPost_no());
        commentDto.setUser_id(commentEntity.getUser_id());
        commentDto.setComment_content(commentEntity.getComment_content());
        return commentDto;
    }
}
