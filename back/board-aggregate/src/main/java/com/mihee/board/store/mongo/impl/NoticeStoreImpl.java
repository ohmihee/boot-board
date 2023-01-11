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
    public void create(Notice notice) {
        NoticeDoc noticeDoc = new NoticeDoc(notice);
        this.noticeRepository.save(noticeDoc);
    }

    @Override
    public Notice findById(String id) {
        return this.noticeRepository.findById(id).get().toDomain();
    }

    @Override
    public void modify(Notice notice) {
        NoticeDoc noticeDoc = new NoticeDoc(notice);
        this.noticeRepository.save(noticeDoc);
    }

    @Override
    public Boolean isExist(String id) {
        return this.noticeRepository.findById(id).isPresent();
    }

    @Override
    public List<Notice> findAll() {
        return NoticeDoc.toDomains(this.noticeRepository.findAll());
    }

    @Override
    public void deleteBoardById(String id) {
        this.noticeRepository.deleteById(id);
    }
}
