package com.example.simpleboard.service;

import com.example.simpleboard.domain.repository.BoardRepository;
import com.example.simpleboard.dto.BoardDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class BoardService {
    private BoardRepository boardRepository;

    @Transactional //If I don't use this, entity is not added.
    public Long savePost(BoardDto boardDto){
        boardDto.setCreatedDate(LocalDateTime.now());
        return boardRepository.save(boardDto.toEntity()).getId();
    }
}
