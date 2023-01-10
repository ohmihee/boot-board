package com.mihee.board;

import com.mihee.board.domain.Board;
import com.mihee.board.impl.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardServiceImpl boardService;

    @PostMapping
    public void createBoard(@RequestBody Board board) {
        System.out.println(board);
        this.boardService.createBoard(board);
    }

    @PostMapping("/edit")
    public void updateBoard(@RequestBody Board board) {
        this.boardService.update(board);
    }

    @GetMapping
    public List<Board> findAllBoard() {
        return this.boardService.getAllBoard();
    }

    @GetMapping("/{id}")
    public Board findBoardById(@PathVariable String id) {
        return this.boardService.getBoardById(id);
    }
    
    @DeleteMapping("/{id}")
    public void removeBoardById(@PathVariable String id) {
        this.boardService.removeBoardById(id);
    }

}
