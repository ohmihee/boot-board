package com.mihee.board.store.mongo;

import com.mihee.board.domain.Board;
import com.mihee.board.domain.dto.board.BoardCdo;
import com.mihee.board.domain.dto.board.BoardRdo;
import com.mihee.board.store.mongo.repository.doc.BoardDoc;

import java.util.List;

public interface BoardStore {

    String create(BoardCdo boardCdo);

    Board findById(String id);

    String modify(BoardDoc boardDoc);

    //
//    Boolean isExist(String id);
//
    List<BoardDoc> findAll();

    //
    void deleteBoardById(String id);

    List<BoardDoc> findByCategory(String category);
}
