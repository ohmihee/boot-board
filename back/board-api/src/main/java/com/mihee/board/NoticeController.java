package com.mihee.board;

import com.mihee.board.domain.Faq;
import com.mihee.board.domain.Notice;
import com.mihee.board.domain.dto.board.BoardCdo;
import com.mihee.board.domain.dto.notice.NoticeCdo;
import com.mihee.board.domain.dto.notice.NoticeUdo;
import com.mihee.board.store.mongo.repository.doc.NoticeDoc;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board/notice")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @PostMapping
    public String createBoard(@RequestBody NoticeCdo board) {

        //System.out.println(board.getClass());
        return this.noticeService.createBoard(board);
    }

    @PostMapping("/edit")
    public String updateBoard(@RequestBody NoticeUdo board) {
        return this.noticeService.update(board);
    }

    @GetMapping
    public List<NoticeDoc> findAllBoard() {
        return this.noticeService.getAllBoard();
    }

    @GetMapping("/{id}")
    public Notice findBoardById(@PathVariable String id) {
        return this.noticeService.getBoardById(id);
    }

    @DeleteMapping("/{id}")
    public void removeBoardById(@PathVariable String id) {
        this.noticeService.removeBoardById(id);
    }
}
