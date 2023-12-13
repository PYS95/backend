package com.okestro.community.service;

import com.okestro.community.model.ListDto;

import java.util.List;

public interface BoardService {

    List<ListDto> boardlist();

    ListDto getBoardById(Long id);

}
