package com.mihee.board.store.mongo.impl;

import com.mihee.board.domain.Notice;
import com.mihee.board.domain.dto.notice.NoticeCdo;
import com.mihee.board.domain.dto.notice.NoticeUdo;
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
    public String create(NoticeCdo noticeCdo) {
        NoticeDoc noticeDoc = noticeCdo.toDomain();
        return this.noticeRepository.save(noticeDoc).getId();
    }

    @Override
    public Notice findById(String id) {
        return this.noticeRepository.findById(id).orElseGet(null).toDomain();
    }

    @Override
    public String modify(NoticeUdo notice) {
        NoticeDoc noticeDoc = notice.toDomain();
        return this.noticeRepository.save(noticeDoc).getId();
    }

    @Override
    public Boolean isExist(String id) {
        return this.noticeRepository.findById(id).isPresent();
    }

    @Override
    public List<NoticeDoc> findAll() {
        return this.noticeRepository.findAll();
    }

    @Override
    public void deleteBoardById(String id) {
        this.noticeRepository.deleteById(id);
    }
}
