package com.mihee.board.impl;

import com.mihee.board.BoardService;
import com.mihee.board.domain.Board;
import com.mihee.board.store.mongo.BoardStore;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardStore boardStore;

    @Override
    public void createBoard(Board board) {
        this.boardStore.create(board);
    }

    @Override
    public Board getBoardById(String id) {
        return this.boardStore.findById(id);
    }

    @Override
    public void update (Board board) {
        Board newBoard = this.boardStore.findById(board.getId());
        newBoard.modifyValues(board);
        this.boardStore.modify(newBoard);
    }

    @Override
    public List<Board> getAllBoard () {
        return this.boardStore.findAll();
    }

    @Override
    public void removeBoardById (String id) {
        this.boardStore.deleteBoardById(id);
    }
}
