package com.okestro.community.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no")
    private Long userNo;    // 회원 번호 (PK)

    @NotBlank(message = "아이디를 입력해주세요.")
    @Column(name = "user_id", nullable = false, unique = true)
    private String userId;  // 회원 Id

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Column(name = "user_pw", nullable = false)
    private String userPw;  // 비밀번호

}