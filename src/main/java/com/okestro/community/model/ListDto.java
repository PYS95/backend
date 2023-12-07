package com.okestro.community.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListDto {

    private int id;
    private String title;
    private String name;
    private String content;
    //private int commentCount;
    private  String commentCount;
//    private String[] comment; // 추후 구현

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

//    public void setCommentCount(int commentCount) {
//        this.commentCount = commentCount;
//    }
    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }

//    public void setComment(String[] comment) {
//        this.comment = comment;
//    } // 추후 구현
}
