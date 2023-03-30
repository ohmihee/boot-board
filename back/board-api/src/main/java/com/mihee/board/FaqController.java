package com.mihee.board;

import com.mihee.board.domain.Board;
import com.mihee.board.domain.Faq;
import com.mihee.board.store.mongo.repository.doc.FaqDoc;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board/faq")
@RequiredArgsConstructor
public class FaqController {

private final FaqService boardService;

@PostMapping
public String createBoard(@RequestBody FaqDoc faqDoc) {

    //System.out.println(board.getClass());
    return this.boardService.createBoard(faqDoc);
}

@PostMapping("/edit")
public String updateBoard(@RequestBody FaqDoc faqDoc) {

    return this.boardService.update(faqDoc);
}

@GetMapping
public List<FaqDoc> findAllBoard() {
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
