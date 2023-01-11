package com.mihee.board.impl;

import com.mihee.board.NoticeService;
import com.mihee.board.domain.Notice;
import com.mihee.board.store.mongo.NoticeStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NoticeServiceImpl implements NoticeService {
    private final NoticeStore noticeStore;
    @Override
    public void createBoard(Notice notice) {
        this.noticeStore.create(notice);
    }

    @Override
    public Notice getBoardById(String id) {
        return this.noticeStore.findById(id);
    }

    @Override
    public void update(Notice notice) {
        Notice newNotice = this.noticeStore.findById(notice.getId());
        newNotice.modifyValues(notice);
        this.noticeStore.modify(newNotice);
    }

    @Override
    public List<Notice> getAllBoard() {
        return this.noticeStore.findAll();
    }

    @Override
    public void removeBoardById(String id) {
        this.noticeStore.deleteBoardById(id);
    }
}
