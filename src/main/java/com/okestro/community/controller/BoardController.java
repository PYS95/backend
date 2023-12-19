package com.okestro.community.controller;

import com.okestro.community.model.ListDto;
import com.okestro.community.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoardController {


    @Autowired
    private BoardService testService;

    @GetMapping("/getBoardList")
    public List<ListDto> boardList() {
        return  testService.boardlist();
    }

    @GetMapping("/getBoardList/{id}")
    public ListDto detailList(@PathVariable Long id) {
        return testService.getBoardById(id);
    }
}

