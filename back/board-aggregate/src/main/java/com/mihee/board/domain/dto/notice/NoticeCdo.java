package com.mihee.board.domain.dto.notice;

import com.mihee.board.domain.vo.BoardContent;
import com.mihee.board.domain.vo.OpenStatus;
import com.mihee.board.store.mongo.repository.doc.BoardDoc;
import com.mihee.board.store.mongo.repository.doc.NoticeDoc;
import java.util.List;
import org.springframework.beans.BeanUtils;

public class NoticeCdo {

    private String category;
    private String title;
    private List<BoardContent> contents;
    private OpenStatus openStatus;

    public NoticeDoc toDomain() {
        NoticeDoc noticeDoc = new NoticeDoc();
        BeanUtils.copyProperties(this, noticeDoc);
        return noticeDoc;
    }
}
