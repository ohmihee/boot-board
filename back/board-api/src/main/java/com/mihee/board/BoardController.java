package com.mihee.board;

import com.mihee.board.domain.Board;
import com.mihee.board.store.mongo.repository.doc.BoardDoc;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("")
    public String createBoard(@RequestBody BoardDoc boardDoc) {
        return this.boardService.createBoard(boardDoc);
    }

    @PostMapping("/edit")
    public void updateBoard(@RequestBody BoardDoc boardDoc) {
        this.boardService.update(boardDoc);
    }

    @GetMapping
    public List<BoardDoc> findAllBoard() {
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
