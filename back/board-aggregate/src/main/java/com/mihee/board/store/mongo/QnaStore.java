package com.mihee.board.store.mongo;

import com.mihee.board.domain.Qna;
import com.mihee.board.store.mongo.repository.doc.QnaDoc;

import java.util.List;

public interface QnaStore {
    void create (QnaDoc qna);
    Qna findById (String id);
    void modify (Qna qna);
    Boolean isExist (String id);
    List<QnaDoc> findAll ();
    void deleteBoardById(String id);
}
