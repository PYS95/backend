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
    public boolean isUsernameUnique(String user_id) {
        return !userRepository.existsById(Long.valueOf(user_id));
    }

    @Override
    public void registerUser(String user_id, String user_pw) {
        userRepository.saveAndFlush(new UserEntity(user_id, user_pw));
    }
}