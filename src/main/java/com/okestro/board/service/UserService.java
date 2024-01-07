package com.okestro.board.service;

import com.okestro.board.model.UserDto;

public interface UserService {

    boolean isUsernameUnique(String userId);

    void registerUser(String userId, String userPw);

    UserDto getUser(String userId);

    boolean updateUserPassword(String userId, String userPw);

    boolean deleteUser(String userId);
}