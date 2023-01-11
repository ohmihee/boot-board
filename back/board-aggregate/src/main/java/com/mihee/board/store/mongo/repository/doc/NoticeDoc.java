package com.mihee.board.store.mongo.repository.doc;

import com.mihee.board.domain.BaseEntity;
import com.mihee.board.domain.Notice;
import com.mihee.board.domain.vo.OpenStatus;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class NoticeDoc extends BaseEntity {
    private String title;
    private String contents;
    private String writer;
    private OpenStatus openStatus;

    public NoticeDoc(Notice notice) {
        BeanUtils.copyProperties(notice, this);
    }
    public  Notice toDomain() {
        Notice notice = new Notice();
        BeanUtils.copyProperties(this, notice);
        return notice;
    }

    public static List<Notice> toDomains(List<NoticeDoc> notices) {
        return notices.stream().map(NoticeDoc::toDomain).collect(Collectors.toList());
    }
}
