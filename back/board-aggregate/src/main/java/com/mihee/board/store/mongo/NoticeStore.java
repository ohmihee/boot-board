package com.mihee.board.store.mongo;

import com.mihee.board.domain.Notice;

import java.util.List;

public interface NoticeStore {
    void create (Notice notice);
    Notice findById (String id);
    void modify (Notice notice);
    Boolean isExist (String id);
    List<Notice> findAll ();
    void deleteBoardById(String id);
}
