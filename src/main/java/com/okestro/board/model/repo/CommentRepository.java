package com.okestro.board.model.repo;

import com.okestro.board.model.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "commentRepository")
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
}
