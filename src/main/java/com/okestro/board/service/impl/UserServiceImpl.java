package com.okestro.board.service.impl;

import com.okestro.board.model.UserDto;
import com.okestro.board.model.entity.UserEntity;
import com.okestro.board.model.repo.UserRepository;
import com.okestro.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;
//    public UserServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @Override
    public boolean isUsernameUnique(String user_id) {
        return !userRepository.existsByUserId(user_id);
    }

    @Override
    public void registerUser(String user_id, String user_pw) {

        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(user_id);
        userEntity.setUserPw(user_pw);
        userRepository.save(userEntity);
    }

    @Override
    public UserDto getUser(String user_id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByUserId(user_id);
        return optionalUserEntity.map(this::convertToUserDto).orElse(null);
    }

    @Override
    public boolean updateUserPassword(String user_id, String user_pw) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByUserId(user_id);
        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();
            userEntity.setUserPw(user_pw);
            userRepository.save(userEntity);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUser(String user_id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByUserId(user_id);
        if (optionalUserEntity.isPresent()) {
            userRepository.delete(optionalUserEntity.get());
            return true;
        }
        return false;
    }

    @Override
    public boolean checkPassword(String user_id, String current_user_pw) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByUserId(user_id);
        return optionalUserEntity
                .map(userEntity -> userEntity.getUserPw().equals(current_user_pw))
                .orElse(false);
    }

    private UserDto convertToUserDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setUser_id(userEntity.getUserId());
        return userDto;
    }
}