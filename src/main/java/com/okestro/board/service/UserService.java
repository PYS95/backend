package com.okestro.board.service;

public interface UserService {
    boolean isUsernameUnique(String userId);

    void registerUser(String userId, String userPw);
}