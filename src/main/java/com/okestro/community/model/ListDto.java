package com.okestro.community.model;

import lombok.Setter;

@Setter
public class ListDto {

    private int id;
    private String title;
    private String name;
    private String content;
    //    public void setCommentCount(int commentCount) {
    //        this.commentCount = commentCount;
    //    }
    //private int commentCount;
    private  String commentCount;
//    private String[] comment; // 추후 구현

    //    public void setComment(String[] comment) {
//        this.comment = comment;
//    } // 추후 구현
}
