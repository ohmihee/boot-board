package com.mihee.board.impl;

import com.mihee.board.NoticeService;
import com.mihee.board.domain.Notice;
import com.mihee.board.domain.dto.notice.NoticeCdo;
import com.mihee.board.domain.dto.notice.NoticeUdo;
import com.mihee.board.store.mongo.NoticeStore;
import com.mihee.board.store.mongo.repository.doc.NoticeDoc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NoticeServiceImpl implements NoticeService {

    private final NoticeStore noticeStore;

    @Override
    public String createBoard(NoticeCdo noticeCdo) {
        return this.noticeStore.create(noticeCdo);
    }

    @Override
    public Notice getBoardById(String id) {
        return this.noticeStore.findById(id);
    }

    @Override
    public String update(NoticeUdo notice) {
        return this.noticeStore.modify(notice);
    }

    @Override
    public List<NoticeDoc> getAllBoard() {
        return this.noticeStore.findAll();
    }

    @Override
    public void removeBoardById(String id) {
        this.noticeStore.deleteBoardById(id);
    }
}
