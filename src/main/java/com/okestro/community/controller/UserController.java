package com.okestro.community.controller;

import com.okestro.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("checkUsername/{user_name}")
    public boolean checkUsername(@PathVariable String user_name) {
        return userService.isUsernameUnique(user_name);
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody UserRequest request) {
        String user_name = request.getUser_name();
        String user_pw = request.getUser_pw();

        if (!userService.isUsernameUnique(user_name)) {
            userService.registerUser(user_name, user_pw);
        } else {
            throw new RuntimeException("이미 존재하는 아이디입니다.");
        }
    }

    private static class UserRequest {
        private String user_name;
        private String user_pw;

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getUser_pw() {
            return user_pw;
        }

        public void setUser_pw(String user_pw) {
            this.user_pw = user_pw;
        }
    }
}
