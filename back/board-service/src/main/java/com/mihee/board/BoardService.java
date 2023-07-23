package com.mihee.board;

import com.mihee.board.domain.dto.board.BoardCdo;
import com.mihee.board.domain.dto.board.BoardRdo;
import com.mihee.board.domain.dto.board.BoardUdo;

import com.mihee.board.store.mongo.repository.doc.BoardDoc;
import java.util.List;

public interface BoardService {

    String createBoard(BoardCdo board);

    BoardRdo getBoardById(String id);

    String update(BoardUdo boardUdo);

    //
    List<BoardRdo> getAllBoard();

    //
    void removeBoardById(String id);

    List<BoardRdo> getBoardByCategory(String category);
}
