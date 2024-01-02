package com.okestro.community.model;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int user_no;

    @Getter
    @Column(nullable = false, unique = true)
    private String user_id;

    @Column(nullable = false)
    private String user_pw;

    public UserEntity(String user_id, String user_pw) {
        this.user_id = user_id;
        this.user_pw = user_pw;
    }
}