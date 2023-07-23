package com.mihee.board.store.mongo;

import com.mihee.board.domain.Notice;
import com.mihee.board.domain.dto.notice.NoticeCdo;
import com.mihee.board.domain.dto.notice.NoticeUdo;
import com.mihee.board.store.mongo.repository.doc.NoticeDoc;

import java.util.List;

public interface NoticeStore {

    String create(NoticeCdo noticeCdo);

    Notice findById(String id);

    String modify(NoticeUdo notice);

    Boolean isExist(String id);

    List<NoticeDoc> findAll();

    void deleteBoardById(String id);
}
