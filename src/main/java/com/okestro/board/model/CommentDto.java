package com.okestro.board.model;

import lombok.Data;

@Data
public class CommentDto {
    private Long comment_no;
    private Long post_no;
    private String user_id;
    private String comment_content;
}
