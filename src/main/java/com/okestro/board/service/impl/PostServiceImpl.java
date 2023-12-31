package com.okestro.board.service.impl;


import com.okestro.board.model.PostDto;
import com.okestro.board.model.entity.PostEntity;
import com.okestro.board.model.repo.PostRepository;
import com.okestro.board.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PostServiceImpl implements PostService {

    @Autowired
    @Qualifier("postRepository")
    private PostRepository postRepository;

    // 게시글 목록 가져오기
    @Override
    public List<PostDto> getPostList() {
        List<PostEntity> postEntities = postRepository.findAll();
        List<PostDto> postDtoList = new ArrayList<>();

        for(PostEntity postEntity : postEntities) {
            PostDto postDto = PostDto.builder()
                    .post_no(postEntity.getPost_no())
                    .post_title(postEntity.getPost_title())
                    .user_id(postEntity.getUser_id())
                    .post_content(postEntity.getPost_content())
                    .post_comment_cnt(postEntity.getPost_comment_cnt())
                    .post_pw(postEntity.getPost_pw())
                    .build();
            postDtoList.add(postDto);
        }
        return postDtoList;
    }

    // 게시글 가져오기
    @Override
    public PostDto getPost(Long post_no) {
        PostEntity postEntity = postRepository.findById(post_no).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. post_no=" + post_no));
        return PostDto.builder()
                .post_no(postEntity.getPost_no())
                .post_title(postEntity.getPost_title())
                .user_id(postEntity.getUser_id())
                .post_content(postEntity.getPost_content())
                .post_comment_cnt(postEntity.getPost_comment_cnt())
                .post_pw(postEntity.getPost_pw())
                .build();
    }

    // 게시글 생성
    @Override
    public PostEntity createPost(PostDto postDto) {
        PostEntity postEntity = PostEntity.builder()
                .post_title(postDto.getPost_title())
                .post_content(postDto.getPost_content())
                .post_pw(postDto.getPost_pw())
                .build();
        return postRepository.save(postEntity);
    }

    // 게시글 수정
    @Override
    public PostEntity updatePost(Long post_no, PostDto postDto) {
        PostEntity postEntity = postRepository.findById(post_no).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. post_no=" + post_no));
        postEntity.setPost_title(postDto.getPost_title());
        postEntity.setPost_content(postDto.getPost_content());
        return null;
    }

    // 게시글 삭제
    @Override
    public void deletePost(Long post_no) {
        PostEntity postEntity = postRepository.findById(post_no).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. post_no=" + post_no));
        postRepository.delete(postEntity);
    }
}