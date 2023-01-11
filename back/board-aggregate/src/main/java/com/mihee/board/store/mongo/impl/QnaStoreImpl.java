package com.mihee.board.store.mongo.impl;

import com.mihee.board.domain.Qna;
import com.mihee.board.store.mongo.QnaStore;
import com.mihee.board.store.mongo.repository.QnaRepository;
import com.mihee.board.store.mongo.repository.doc.QnaDoc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class QnaStoreImpl implements QnaStore {

    private final QnaRepository qnaRepository;
    @Override
    public void create(Qna qna) {
        QnaDoc qnaDoc = new QnaDoc(qna);
        this.qnaRepository.save(qnaDoc);
    }

    @Override
    public Qna findById(String id) {
        return this.qnaRepository.findById(id).get().toDomain();
    }

    @Override
    public void modify(Qna qna) {
        QnaDoc qnaDoc = new QnaDoc(qna);
        this.qnaRepository.save(qnaDoc);
    }

    @Override
    public Boolean isExist(String id) {
        return this.qnaRepository.findById(id).isPresent();
    }

    @Override
    public List<Qna> findAll() {
        return QnaDoc.toDomains(this.qnaRepository.findAll());
    }

    @Override
    public void deleteBoardById(String id) {
        this.qnaRepository.deleteById(id);
    }
}
