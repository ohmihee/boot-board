package com.mihee.board.domain;

import com.mihee.board.domain.vo.OpenStatus;
import com.mihee.board.store.mongo.repository.doc.QnaDoc;
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
public class Qna extends BaseEntity{
    private String question;
    private String questioner;
    private String answer;
    private String respondent;
    private Long answerDate;
    private OpenStatus openStatus;

    public Qna (QnaDoc qnaDoc) {
        BeanUtils.copyProperties(qnaDoc, this);
    }

    public QnaDoc toDomain() {
        QnaDoc qnaDoc =  new QnaDoc();
        BeanUtils.copyProperties(this, qnaDoc);
        return qnaDoc;
    }

    public static List<QnaDoc> toDomains(List<Qna> qnas) {
        return qnas.stream().map(Qna::toDomain).collect(Collectors.toList());
    }
    public void modifyValues(Qna qna) {
        Map<String, Object> valueList = EntityUtil.MapFromObj(qna);
        for (Map.Entry<String, Object> entry: valueList.entrySet()) {
            if (entry.getValue() != null) {
                switch (entry.getKey()) {
                    case "question":
                        this.question = entry.getValue().toString();
                        break;
                    case "questioner":
                        this.questioner = entry.getValue().toString();
                        break;
                    case "answer":
                        this.answer = entry.getValue().toString();
                        break;
                    case "respondent":
                        this.respondent = entry.getValue().toString();
                        break;
                    case "answerDate":
                        this.answerDate = Long.parseLong(entry.getValue().toString());
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
