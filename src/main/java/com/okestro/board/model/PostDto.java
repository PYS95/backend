package com.okestro.board.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto implements Serializable {
    private Long post_no;
    private String post_title;
    private String user_id;
    private String post_content;
    private int post_comment_cnt;
    private String post_pw;
}
