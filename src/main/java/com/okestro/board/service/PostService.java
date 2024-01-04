package com.okestro.board.service;

import com.okestro.board.model.PostDto;
import com.okestro.board.model.entity.PostEntity;

import java.util.List;

public interface PostService {
    List<PostDto> getPostList();
    PostDto getPost(Long post_no);
    PostEntity createPost(PostDto postDto);
    PostEntity updatePost(Long post_no, PostDto postDto);
    void deletePost(Long post_no);

}
