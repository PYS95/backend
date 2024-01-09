package com.okestro.board.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="comment")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_no")
    private Long comment_no;

    @Column(name = "post_no")
    private Long post_no;

    @Column(name = "user_id")
    private String user_id;

    @Column(name = "comment_content")
    private String comment_content;
}
