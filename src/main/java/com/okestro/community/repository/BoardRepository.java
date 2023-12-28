package com.okestro.community.repository;

import com.okestro.community.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long>{

//    boolean existsByUserid(String name);
}
