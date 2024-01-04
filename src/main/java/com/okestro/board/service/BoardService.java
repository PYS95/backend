package com.okestro.board.service;

import com.okestro.board.model.ListDto;

import java.util.List;

public interface BoardService {

    List<ListDto> boardlist();

    ListDto getBoardById(Long id);

}
