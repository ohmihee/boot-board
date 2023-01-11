package com.mihee.board;

import com.mihee.board.domain.Qna;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board/qna")
@RequiredArgsConstructor
public class QnaController {
    private final QnaService boardService;

    @PostMapping
    public void createBoard(@RequestBody Qna board) {
        //System.out.println(board.getClass());
        this.boardService.createBoard(board);
    }

    @PostMapping("/edit")
    public void updateBoard(@RequestBody Qna board) {
        this.boardService.update(board);
    }

    @GetMapping
    public List<Qna> findAllBoard() {
        return this.boardService.getAllBoard();
    }

    @GetMapping("/{id}")
    public Qna findBoardById(@PathVariable String id) {
        return this.boardService.getBoardById(id);
    }

    @DeleteMapping("/{id}")
    public void removeBoardById(@PathVariable String id) {
        this.boardService.removeBoardById(id);
    }
}
