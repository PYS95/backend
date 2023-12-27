package com.okestro.community.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListDto {

    private Long id;
    private String title;
    private String name;
    private String content;
    private List<String> comments;
    private int commentCount;
}
