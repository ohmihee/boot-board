package com.mihee.board.impl;

import com.mihee.board.QnaService;
import com.mihee.board.domain.Qna;
import com.mihee.board.store.mongo.QnaStore;
import com.mihee.board.store.mongo.repository.doc.QnaDoc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QnaServiceImpl implements QnaService {

    private final QnaStore qnaStore;
    @Override
    public void createBoard(QnaDoc qnaDoc) {
        this.qnaStore.create(qnaDoc);
    }

    @Override
    public Qna getBoardById(String id) {
        return this.qnaStore.findById(id);
    }

    @Override
    public void update(Qna qna) {
        Qna newQna = this.qnaStore.findById(qna.getId());
        newQna.modifyValues(qna);
        this.qnaStore.modify(newQna);
    }

    @Override
    public List<QnaDoc> getAllBoard() {
        return this.qnaStore.findAll();
    }

    @Override
    public void removeBoardById(String id) {
        this.qnaStore.deleteBoardById(id);
    }
}
