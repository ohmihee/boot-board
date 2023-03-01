package com.mihee.board.domain;

import com.mihee.board.store.mongo.repository.doc.FaqDoc;
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
@NoArgsConstructor
@AllArgsConstructor
public class Faq extends BaseEntity{
    private String title;
    private String question;
    private String answer;
    private String writer;

    public Faq (FaqDoc faqDoc) {
        BeanUtils.copyProperties(faqDoc, this);
    }

    public FaqDoc toDomain () {
        FaqDoc faqDoc = new FaqDoc();
        BeanUtils.copyProperties(this, faqDoc);
        return faqDoc;
    }

    public static List<FaqDoc> toDomains(List<Faq> faqs) {
        return faqs.stream().map(Faq::toDomain).collect(Collectors.toList());
    }

    public void modifyValues(FaqDoc faqDoc) {
        Map<String, Object> valueList = EntityUtil.MapFromObj(faqDoc);
        for(Map.Entry<String, Object> entry: valueList.entrySet()) {
            if (entry.getValue() != null) {
                switch (entry.getKey()) {
                    case "title":
                        this.title = entry.getValue().toString();
                        break;
                    case "question":
                        this.question = entry.getValue().toString();
                        break;
                    case "answer":
                        this.answer = entry.getValue().toString();
                        break;
                }
            }
        }
    }
}
