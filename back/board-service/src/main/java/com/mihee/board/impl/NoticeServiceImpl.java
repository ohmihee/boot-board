package com.mihee.board.impl;

import com.mihee.board.NoticeService;
import com.mihee.board.domain.Notice;
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
    public String createBoard(NoticeDoc notice) {
        return this.noticeStore.create(notice);
    }

    @Override
    public Notice getBoardById(String id) {
        return this.noticeStore.findById(id);
    }

    @Override
    public String update(NoticeDoc notice) {
        Notice newNotice = this.noticeStore.findById(notice.getId());
        newNotice.modifyValues(notice);
        return this.noticeStore.modify(newNotice.toDomain());
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
