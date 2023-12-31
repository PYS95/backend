package com.okestro.community.controller;

//import com.okestro.community.entity.BoardEntity;
//import com.okestro.community.model.BoardDto;
import com.okestro.community.model.ListDto;
import com.okestro.community.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")

public class BoardController {
    private final BoardService boardService;

    @GetMapping("/boardList")
    public List<ListDto> boardList() {
        return boardService.boardlist();
    }

    @GetMapping("/boardList/{id}")
    public ListDto detailList(@PathVariable Long id) {
        return boardService.getBoardById(id);
    }
}

