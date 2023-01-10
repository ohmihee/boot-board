package com.mihee.board;

import com.mihee.board.domain.Board;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BoardService {
    void createBoard(Board board);
    Board getBoardById(String id);
    void update(Board board);
    List<Board> getAllBoard();

    void removeBoardById(String id);
}
