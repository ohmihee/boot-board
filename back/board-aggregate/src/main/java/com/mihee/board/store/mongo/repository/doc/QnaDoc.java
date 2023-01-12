package com.mihee.board.store.mongo.repository.doc;

import com.mihee.board.domain.BaseEntity;
import com.mihee.board.domain.Qna;
import com.mihee.board.domain.vo.OpenStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.stream.Collectors;

@Document("Qna")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QnaDoc extends BaseEntity {
    private String question;
    private String questioner;
    private String answer;
    private String respondent;
    private Long answerDate;
    private OpenStatus openStatus;

    public QnaDoc(Qna qna) {
        BeanUtils.copyProperties(qna, this);
    }

    public Qna toDomain() {
        Qna qna = new Qna();
        BeanUtils.copyProperties(this, qna);
        return qna;
    }

    public static List<Qna> toDomains(List<QnaDoc> qnas) {
        return qnas.stream().map(QnaDoc:: toDomain).collect(Collectors.toList());
    }

}
