package com.okestro.community.service;

public interface UserService {

    boolean isUsernameUnique(String user_name);
    void registerUser(String user_name, String user_pw);
}
