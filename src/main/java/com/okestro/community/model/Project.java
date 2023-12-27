package com.okestro.community.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "project")

public class Project {

    @Id // PK값
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 id 생성

    private Long id;

    @Column(nullable = false, unique = true) // 중복X
    private String userid;

    @Column(nullable = false)
    private String username;
}
