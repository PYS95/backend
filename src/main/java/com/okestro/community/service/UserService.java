package com.okestro.community.service;

import com.okestro.community.repo.UserRepository;

public interface UserService {
    boolean isUsernameUnique(String user_id);

    void registerUser(String user_id, String user_pw);
}