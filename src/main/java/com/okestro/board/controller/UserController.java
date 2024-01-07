package com.okestro.board.controller;

import com.okestro.board.model.UserDto;
import com.okestro.board.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/{user_id}")
    public ResponseEntity<String> signUp(@PathVariable String user_id, @RequestBody UserDto userDto) {
        try {
            String decodedUserId = URLDecoder.decode(user_id);
            System.out.println("Received URL: " + decodedUserId);

            // 추가된 부분: 비밀번호가 비어있는지 여부 확인
            if (StringUtils.isEmpty(userDto.getUser_pw())) {
                return new ResponseEntity<>("비밀번호를 입력해주세요.", HttpStatus.BAD_REQUEST);
            }

            if (userService.isUsernameUnique(decodedUserId)) {
                userService.registerUser(decodedUserId, userDto.getUser_pw());
                return new ResponseEntity<>("회원가입에 성공하였습니다." + decodedUserId + "님 환영합니다.", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("이미 존재하는 아이디입니다.", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("회원가입에 실패하였습니다. 오류: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<UserDto> getUser(@PathVariable String user_id) {
        UserDto userDto = userService.getUser(user_id);
        if (userDto != null) {
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{user_id}")
    public ResponseEntity<String> updatePassword(@PathVariable String user_id, @RequestBody String user_pw) {
        if (userService.updateUserPassword(user_id, user_pw)) {
            return new ResponseEntity<>("패스워드가 성공적으로 변경되었습니다.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("패스워드 변경에 실패했습니다.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{user_id}")
    public ResponseEntity<String> deleteUser(@PathVariable String user_id) {
        if (userService.deleteUser(user_id)) {
            return new ResponseEntity<>("회원탈퇴가 성공적으로 처리되었습니다.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("회원탈퇴에 실패했습니다.", HttpStatus.BAD_REQUEST);
        }
    }
}