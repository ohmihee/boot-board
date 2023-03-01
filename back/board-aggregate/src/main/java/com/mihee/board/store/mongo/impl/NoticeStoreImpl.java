package com.mihee.board.store.mongo.impl;

import com.mihee.board.domain.Notice;
import com.mihee.board.store.mongo.NoticeStore;
import com.mihee.board.store.mongo.repository.NoticeRepository;
import com.mihee.board.store.mongo.repository.doc.NoticeDoc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class NoticeStoreImpl implements NoticeStore {

    private final NoticeRepository noticeRepository;
    @Override
    public String create(NoticeDoc noticeDoc) {
        Notice notice = new Notice(noticeDoc);
        return this.noticeRepository.save(notice).getId();
    }

    @Override
    public Notice findById(String id) {
        return this.noticeRepository.findById(id).get();
    }

    @Override
    public String modify(NoticeDoc noticeDoc) {
        Notice notice = new Notice(noticeDoc);
        return this.noticeRepository.save(notice).getId();
    }

    @Override
    public Boolean isExist(String id) {
        return this.noticeRepository.findById(id).isPresent();
    }

    @Override
    public List<NoticeDoc> findAll() {
        return Notice.toDomains(this.noticeRepository.findAll());
    }

    @Override
    public void deleteBoardById(String id) {
        this.noticeRepository.deleteById(id);
    }
}
