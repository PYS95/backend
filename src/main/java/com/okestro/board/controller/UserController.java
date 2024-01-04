package com.okestro.board.controller;

import com.okestro.board.model.UserEntity;
import com.okestro.board.service.UserService;
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

    @PostMapping("/{user_id}")
    public ResponseEntity<String> registerUser(@RequestBody UserEntity request, @PathVariable("user_id") String userId) {
        String userPw = request.getUserPw();

        if (!userService.isUsernameUnique(userId)) {
            userService.registerUser(userId, userPw);
            return new ResponseEntity<>("회원가입에 성공하였습니다." + userId + "님 환영합니다.", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("이미 존재하는 아이디입니다.", HttpStatus.BAD_REQUEST);
        }
    }
}