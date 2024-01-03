package com.okestro.community.service;

public interface UserService {
    boolean isUsernameUnique(String user_id);

    void registerUser(String user_id, String user_pw);
}