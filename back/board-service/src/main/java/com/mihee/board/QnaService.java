package com.mihee.board;

import com.mihee.board.domain.Qna;

import java.util.List;

public interface QnaService {
    void createBoard(Qna qna);
    Qna getBoardById(String id);
    void update(Qna qna);
    List<Qna> getAllBoard();
    void removeBoardById(String id);
}
