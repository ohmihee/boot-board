package com.mihee.board.domain;

import com.mihee.board.domain.vo.BoardContent;
import com.mihee.board.domain.vo.OpenStatus;
import com.mihee.board.store.mongo.repository.doc.NoticeDoc;
import com.mihee.board.util.EntityUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Notice extends BaseEntity{
    private String title;
    private List<BoardContent> contents;
    private String writer;
    private OpenStatus openStatus;

    public Notice (NoticeDoc noticeDoc ) {
        BeanUtils.copyProperties(noticeDoc, this);
    }

    public NoticeDoc toDomain () {
        NoticeDoc noticeDoc = new NoticeDoc();
        BeanUtils.copyProperties(this, noticeDoc);
        return noticeDoc;
    }

    public static List<NoticeDoc> toDomains(List<Notice> noticeList) {
        return noticeList.stream().map(Notice::toDomain).collect(Collectors.toList());
    }
    public void modifyValues(NoticeDoc notice) {
        Map<String, Object> valueList = EntityUtil.MapFromObj(notice);
        for(Map.Entry<String, Object> entry: valueList.entrySet()) {
            if (entry.getValue() != null) {
                switch (entry.getKey()) {
                    case "title":
                        this.title = entry.getValue().toString();
                        break;
                    case "contents":
                        this.contents =(List<BoardContent>) entry.getValue();
                        break;
                    case "openStatus":
                        if (entry.getValue().equals("All"))
                            this.openStatus = OpenStatus.All;
                        if (entry.getValue().equals("OnlyAdmin"))
                            this.openStatus = OpenStatus.OnlyAdmin;
                        break;
                }
            }
        }
    }
}
