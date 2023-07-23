package com.mihee.board;

import com.mihee.board.domain.Notice;
import com.mihee.board.domain.dto.notice.NoticeCdo;
import com.mihee.board.domain.dto.notice.NoticeUdo;
import com.mihee.board.store.mongo.repository.doc.NoticeDoc;

import java.util.List;

public interface NoticeService {

    String createBoard(NoticeCdo notice);

    Notice getBoardById(String id);

    String update(NoticeUdo notice);

    List<NoticeDoc> getAllBoard();

    void removeBoardById(String id);
}
