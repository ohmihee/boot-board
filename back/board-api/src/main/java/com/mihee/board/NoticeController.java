package com.mihee.board;

import com.mihee.board.domain.Faq;
import com.mihee.board.domain.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board/notice")
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService boardService;

    @PostMapping
    public void createBoard(@RequestBody Notice board) {

        //System.out.println(board.getClass());
        this.boardService.createBoard(board);
    }

    @PostMapping("/edit")
    public void updateBoard(@RequestBody Notice board) {
        this.boardService.update(board);
    }

    @GetMapping
    public List<Notice> findAllBoard() {
        return this.boardService.getAllBoard();
    }

    @GetMapping("/{id}")
    public Notice findBoardById(@PathVariable String id) {
        return this.boardService.getBoardById(id);
    }

    @DeleteMapping("/{id}")
    public void removeBoardById(@PathVariable String id) {
        this.boardService.removeBoardById(id);
    }
}
