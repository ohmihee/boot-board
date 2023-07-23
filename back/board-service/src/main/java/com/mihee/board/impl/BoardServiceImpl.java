package com.mihee.board.impl;

import com.mihee.board.BoardService;
import com.mihee.board.domain.Board;
import com.mihee.board.domain.dto.board.BoardCdo;
import com.mihee.board.domain.dto.board.BoardRdo;
import com.mihee.board.domain.dto.board.BoardUdo;
import com.mihee.board.store.mongo.BoardStore;

import com.mihee.board.store.mongo.repository.doc.BoardDoc;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardStore boardStore;
    private final BCryptPasswordEncoder encoder;


    @Override
    public String createBoard(BoardCdo boardCdo) {
        return this.boardStore.create(boardCdo);
    }

    @Override
    public BoardRdo getBoardById(String id) {
        Board board = this.boardStore.findById(id);
        BoardRdo boardRdo = new BoardRdo(board);
        return boardRdo;
    }

    @Override
    public List<BoardRdo> getBoardByCategory(String category) {
        List<BoardDoc> boards = this.boardStore.findByCategory(category);
        return boards.stream().map((ele) -> new BoardRdo(ele.toDomain()))
                .collect(Collectors.toList());
    }

    //
    @Override
    public String update(BoardUdo boardUdo) {
        Board newBoard = this.boardStore.findById(boardUdo.getId());
        newBoard.modifyValues(boardUdo);
        return this.boardStore.modify(newBoard.toDomain());
    }

    //
    @Override
    public List<BoardRdo> getAllBoard() {
        List<BoardDoc> boards = this.boardStore.findAll();
        return boards.stream().map((ele) -> new BoardRdo(ele.toDomain()))
                .collect(Collectors.toList());
    }

    //
    @Override
    public void removeBoardById(String id) {
        this.boardStore.deleteBoardById(id);
    }
}
