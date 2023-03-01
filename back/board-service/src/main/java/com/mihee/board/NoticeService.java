package com.mihee.board;

import com.mihee.board.domain.Notice;
import com.mihee.board.store.mongo.repository.doc.NoticeDoc;

import java.util.List;

public interface NoticeService {
    String createBoard(NoticeDoc notice);
    Notice getBoardById(String id);
    String update(NoticeDoc notice);
    List<NoticeDoc> getAllBoard();
    void removeBoardById(String id);
}
