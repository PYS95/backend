package com.okestro.community.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data                   // Getter Setter
@NoArgsConstructor      // 기본 생성자
@AllArgsConstructor     // 모든 컬럼 생성자 생성
public class ListDto {

    private Long id;                // 레시물 리스트 순번
    private String title;           // 게시물 제목
    private String name;            // 작성자
    private String content;         // 게시물 내용
    private List<String> comments;  // 댓글 리스트
    private int commentCount;       // 댓글 개수
}

