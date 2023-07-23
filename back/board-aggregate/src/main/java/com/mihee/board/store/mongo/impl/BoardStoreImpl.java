package com.mihee.board.store.mongo.impl;

import com.mihee.board.domain.Board;
import com.mihee.board.domain.dto.board.BoardCdo;
import com.mihee.board.store.mongo.BoardStore;
import com.mihee.board.store.mongo.repository.BoardRepository;
import com.mihee.board.store.mongo.repository.doc.BoardDoc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class BoardStoreImpl implements BoardStore {

    private final BoardRepository boardRepository;

    @Override
    public String create(BoardCdo boardCdo) {
        BoardDoc boardDoc = boardCdo.toDomain();
        return this.boardRepository.save(boardDoc).getId();
    }

    //
    @Override
    public Board findById(String id) {
        return this.boardRepository.findById(id).orElseGet(null).toDomain();
        //return boardDoc.map(BoardDoc::toDomain).orElse(null);
    }

    //
    @Override
    public String modify(BoardDoc boardDoc) {
        // Board board = new Board(boardDoc);
        return this.boardRepository.save(boardDoc).getId();
    }

    //
//    @Override
//    public Boolean isExist(String id) {
//        return this.boardRepository.findById(id).isPresent();
//    }
//
//    //    @Override

    @Override
    public List<BoardDoc> findByCategory(String category) {
        return this.boardRepository.findAllByCategory(category);
    }

    @Override
    public List<BoardDoc> findAll() {
        return this.boardRepository.findAll();
    }

    //
    @Override
    public void deleteBoardById(String id) {
        this.boardRepository.deleteById(id);
    }
}
