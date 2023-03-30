package com.mihee.board.store.mongo;

import com.mihee.board.domain.Board;
import com.mihee.board.store.mongo.repository.doc.BoardDoc;

import java.util.List;
import java.util.Optional;

public interface BoardStore {

    String create(BoardDoc boardDoc);

    Board findById(String id);

    String modify(Board board);

    Boolean isExist(String id);

    List<Board> findAll();

    void deleteBoardById(String id);
}
