package com.mihee.board.store.mongo.repository.doc;

import com.mihee.board.domain.BaseEntity;
import com.mihee.board.domain.Faq;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FaqDoc extends BaseEntity {
    private String title;
    private String question;
    private String answer;
    private String writer;

    public FaqDoc(Faq faq) {
        BeanUtils.copyProperties(faq, this);
    }

    public Faq toDomain() {
        Faq faq = new Faq();
        BeanUtils.copyProperties(this, faq);
        return faq;
    }

    public static List<Faq> toDomains(List<FaqDoc> faqs) {
        return faqs.stream().map(FaqDoc::toDomain).collect(Collectors.toList());
    }
}
