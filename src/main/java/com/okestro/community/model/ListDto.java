package com.okestro.community.model;

import lombok.Data;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Data
public class ListDto {

    private Long id;
    private String title;
    private String name;
    private String content;
    private List<String> comments = new ArrayList<>();
    private int commentCount;

}
