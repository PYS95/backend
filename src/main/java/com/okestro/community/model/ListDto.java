package com.okestro.community.model;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ListDto {

    private Long id;
    private String title;
    private String name;
    private String content;
    private List<String> comments;
    private int commentCount;

//    public ListDto(Long id, String title, String name, String content, List<String> comments, int commentCount) {
//        this.id = id;
//        this.title = title;
//        this.name = name;
//        this.content = content;
//        this.comments = comments;
//        this.commentCount = commentCount;
//    }
}
