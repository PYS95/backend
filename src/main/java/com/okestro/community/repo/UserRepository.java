package com.okestro.community.repo;

import com.okestro.community.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByUsername(String user_name);
}
