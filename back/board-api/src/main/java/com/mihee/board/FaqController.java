package com.mihee.board;

import com.mihee.board.domain.Board;
import com.mihee.board.domain.Faq;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board/faq")
@RequiredArgsConstructor
public class FaqController {
    private final FaqService boardService;

    @PostMapping
    public void createBoard(@RequestBody Faq board) {

        //System.out.println(board.getClass());
        this.boardService.createBoard(board);
    }

    @PostMapping("/edit")
    public void updateBoard(@RequestBody Faq board) {
        this.boardService.update(board);
    }

    @GetMapping
    public List<Faq> findAllBoard() {
        return this.boardService.getAllBoard();
    }

    @GetMapping("/{id}")
    public Faq findBoardById(@PathVariable String id) {
        return this.boardService.getBoardById(id);
    }

    @DeleteMapping("/{id}")
    public void removeBoardById(@PathVariable String id) {
        this.boardService.removeBoardById(id);
    }


}
