package com.mihee.board;

import com.mihee.board.domain.Board;
import com.mihee.board.store.mongo.repository.doc.BoardDoc;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BoardService {
    String createBoard(BoardDoc board);
    Board getBoardById(String id);
    void update(BoardDoc boardDoc);
    List<BoardDoc> getAllBoard();

    void removeBoardById(String id);
}
