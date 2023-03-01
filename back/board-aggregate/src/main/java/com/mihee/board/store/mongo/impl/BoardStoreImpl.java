package com.mihee.board.store.mongo.impl;

import com.mihee.board.domain.Board;
import com.mihee.board.store.mongo.BoardStore;
import com.mihee.board.store.mongo.repository.BoardRepository;
import com.mihee.board.store.mongo.repository.doc.BoardDoc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class BoardStoreImpl implements BoardStore {

    private final BoardRepository boardRepository;

    @Override
    public String create(BoardDoc boardDoc) {
        Board board = new Board(boardDoc);
        return this.boardRepository.save(board).getId();
    }

    @Override
    public Board findById(String id) {
        return this.boardRepository.findById(id).orElseGet(null);
        //return boardDoc.map(BoardDoc::toDomain).orElse(null);
    }

    @Override
    public String modify(Board board) {
        // Board board = new Board(boardDoc);
        return this.boardRepository.save(board).getId();
    }

    @Override
    public Boolean isExist (String id) {
        return this.boardRepository.findById(id).isPresent();
    }

    @Override
    public List<BoardDoc> findAll () {
        return Board.toDomains(this.boardRepository.findAll());
    }

    @Override
    public void deleteBoardById (String id) {
        this.boardRepository.deleteById(id);
    }
}
