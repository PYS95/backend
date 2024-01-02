package com.okestro.community.controller;

import com.okestro.community.service.UserService;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotBlank;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("checkUsernames/{user_id}")
    public boolean checkUsername(@PathVariable String user_id) {
        return userService.isUsernameUnique(user_id);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationRequest request) {
        String user_id = request.getUser_id();
        String user_pw = request.getUser_pw();

        if (!userService.isUsernameUnique(user_id)) {
            userService.registerUser(user_id, user_pw);
            return new ResponseEntity<>("회원가입에 성공하였습니다." + user_id + "님 환영합니다.", HttpStatus.CREATED);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "이미 존재하는 아이디입니다.");
        }
    }

    @Data
    @Builder
    private static class UserRegistrationRequest {

        @NotBlank(message = "아이디를 입력해주세요.")
        private String user_id;

        @NotBlank(message = "패스워드를 입력해주세요.")
        private String user_pw;
    }
}