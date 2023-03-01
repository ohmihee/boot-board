package com.mihee.board.impl;

import com.mihee.board.BoardService;
import com.mihee.board.domain.Board;
import com.mihee.board.store.mongo.BoardStore;

import com.mihee.board.store.mongo.repository.doc.BoardDoc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardStore boardStore;


    @Override
    public String createBoard(BoardDoc boardDoc) {
        return this.boardStore.create(boardDoc);
    }

    @Override
    public Board getBoardById(String id) {
        return this.boardStore.findById(id);
    }

    @Override
    public void update (BoardDoc boardDoc) {
        Board newBoard = this.boardStore.findById(boardDoc.getId());
        newBoard.modifyValues(boardDoc);
        this.boardStore.modify(newBoard);
    }

    @Override
    public List<BoardDoc> getAllBoard () {
        return this.boardStore.findAll();
    }

    @Override
    public void removeBoardById (String id) {
        this.boardStore.deleteBoardById(id);
    }
}
