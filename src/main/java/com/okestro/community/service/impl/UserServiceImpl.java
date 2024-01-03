package com.okestro.community.service.impl;

import com.okestro.community.model.UserEntity;
import com.okestro.community.repo.UserRepository;
import com.okestro.community.service.UserService;
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
    public void registerUser(String user_id, String user_pw) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(user_id);
        userEntity.setUserPw(user_pw);
        userRepository.save(userEntity);
    }
}