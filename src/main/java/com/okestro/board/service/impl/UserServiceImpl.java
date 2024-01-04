package com.okestro.board.service.impl;

import com.okestro.board.model.entity.UserEntity;
import com.okestro.board.model.repo.UserRepository;
import com.okestro.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isUsernameUnique(String userId) {
        return userRepository.findByUserId(userId).isPresent();
    }

    @Override
    public void registerUser(String userId, String userPw) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userId);
        userEntity.setUserPw(userPw);
        userRepository.save(userEntity);
    }
}