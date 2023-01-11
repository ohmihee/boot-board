package com.mihee.board.store.mongo;

import com.mihee.board.domain.Qna;

import java.util.List;

public interface QnaStore {
    void create (Qna qna);
    Qna findById (String id);
    void modify (Qna qna);
    Boolean isExist (String id);
    List<Qna> findAll ();
    void deleteBoardById(String id);
}
