package com.okestro.community.controller;

import com.okestro.community.model.UserEntity;
import com.okestro.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }

    @PostMapping("/api/user/{user_id)")
    public ResponseEntity<String> registerUser(@RequestBody UserEntity request) {
        String user_id = request.getUserId();
        String user_pw = request.getUserPw();

        if (!userService.isUsernameUnique(user_id)) {
            userService.registerUser(user_id, user_pw);
            return new ResponseEntity<>("회원가입에 성공하였습니다." + user_id + "님 환영합니다.", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("이미 존재하는 아이디입니다.", HttpStatus.BAD_REQUEST);
        }
    }
}