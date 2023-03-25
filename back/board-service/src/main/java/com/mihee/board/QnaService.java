package com.mihee.board;

import com.mihee.board.domain.Qna;
import com.mihee.board.store.mongo.repository.doc.QnaDoc;

import java.util.List;

public interface QnaService {
    void createBoard(QnaDoc qna);
    Qna getBoardById(String id);
    void update(Qna qna);
    List<QnaDoc> getAllBoard();
    void removeBoardById(String id);
}
