package com.okestro.board.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="post")
@Entity
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_no")
    private Long post_no;

    @Column(name = "post_title")
    private String post_title;

    @Column(name = "user_id")
    private String user_id;

    @Column(name = "post_content")
    private String post_content;

    @Column(name = "post_comment_cnt")
    private int post_comment_cnt;

    @Column(name = "post_pw")
    private String post_pw;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<CommentEntity> comments;
}
