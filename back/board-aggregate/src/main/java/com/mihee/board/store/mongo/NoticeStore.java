package com.mihee.board.store.mongo;

import com.mihee.board.domain.Notice;
import com.mihee.board.store.mongo.repository.doc.NoticeDoc;

import java.util.List;

public interface NoticeStore {
    String create (NoticeDoc notice);
    Notice findById (String id);
    String modify (NoticeDoc notice);
    Boolean isExist (String id);
    List<NoticeDoc> findAll ();
    void deleteBoardById(String id);
}
