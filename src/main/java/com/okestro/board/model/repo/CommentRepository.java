package com.okestro.board.model.repo;

import com.okestro.board.model.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "commentRepository")
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    @Query("SELECT c FROM CommentEntity c WHERE c.post.post_no = :postId")
    List<CommentEntity> findByPost_PostNo(@Param("postId") Long postId);
}
