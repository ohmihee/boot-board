package com.mihee.board;

import com.mihee.board.domain.Faq;
import com.mihee.board.domain.Notice;
import com.mihee.board.store.mongo.repository.doc.NoticeDoc;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board/notice")
@RequiredArgsConstructor
public class NoticeController {

private final NoticeService boardService;

@PostMapping
public String createBoard(@RequestBody NoticeDoc board) {

    //System.out.println(board.getClass());
    return this.boardService.createBoard(board);
}

@PostMapping("/edit")
public String updateBoard(@RequestBody NoticeDoc board) {
    return this.boardService.update(board);
}

@GetMapping
public List<NoticeDoc> findAllBoard() {
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
