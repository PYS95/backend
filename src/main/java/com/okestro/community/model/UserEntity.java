package com.okestro.community.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "board")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String user_pw;

    public UserEntity(String user_pw) {
    }
}
