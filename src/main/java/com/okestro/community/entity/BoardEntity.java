package com.okestro.community.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data                           // Getter Setter
@AllArgsConstructor             // 모든 컬럼 생성자 생성
@NoArgsConstructor              // 기본 생성자
@Builder                        // DTO -> Entity화
@Table(name = "project")
@Entity

public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 id 셍상

    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String password;
}
