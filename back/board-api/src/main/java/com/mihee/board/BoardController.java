package com.mihee.board;

import com.mihee.board.domain.dto.board.BoardCdo;
import com.mihee.board.domain.dto.board.BoardRdo;
import com.mihee.board.domain.dto.board.BoardUdo;
import com.mihee.board.store.mongo.repository.doc.BoardDoc;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("")
    public String createBoard(@RequestBody BoardCdo boardCdo) {
        return this.boardService.createBoard(boardCdo);
    }

    @GetMapping("/category/{category}")
    public List<BoardRdo> findBoardByCategory(@PathVariable String category) {
        return this.boardService.getBoardByCategory(category);
    }

    @GetMapping("/{id}")
    public BoardRdo findBoardById(@PathVariable String id) {
        return this.boardService.getBoardById(id);
    }

    @PostMapping("/edit")
    public String updateBoard(@RequestBody BoardUdo boardUdo) {
        return this.boardService.update(boardUdo);
    }

    //
    @GetMapping
    public List<BoardRdo> findAllBoard() {
        return this.boardService.getAllBoard();
    }

    //
//
    @DeleteMapping("/{id}")
    public void removeBoardById(@PathVariable String id) {
        this.boardService.removeBoardById(id);
    }

}
