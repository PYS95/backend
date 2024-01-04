package com.okestro.board.model.repo;

import com.okestro.board.model.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "postRepository")
public interface PostRepository extends JpaRepository<PostEntity, Long>{
}
