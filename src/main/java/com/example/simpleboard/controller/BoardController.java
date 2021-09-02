package com.example.simpleboard.controller;

import lombok.AllArgsConstructor;
import com.example.simpleboard.service.BoardService;
import com.example.simpleboard.dto.BoardDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller //Autodetection
@AllArgsConstructor
public class BoardController {
    private BoardService boardService;

    @GetMapping("/")
    public String index(){
        return "/index.html";
    }
    @GetMapping("/list")
    public String list(){
        return "board/list.html";
    }
    @GetMapping("/posting_session")
    public String post(){
        return "board/post.html";
    }

    @PostMapping("/post")
    public String post(BoardDto boardDto){
        boardService.savePost(boardDto);
        return "redirect:/list";
    }


}