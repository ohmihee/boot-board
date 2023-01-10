package com.mihee.board.store.mongo.repository.doc;

import com.mihee.board.domain.BaseEntity;
import com.mihee.board.domain.Faq;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Method;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FaqDoc extends BaseEntity {
    private String title;
    private String question;
    private String answer;
    private String writer;
    private Method method ;

//    public FaqDoc(Faq faq) {
//        BeanUtils.copyProperties(faq, this);
//    }
//
//
//    public FaqDoc toDomain() {
//        System.out.println(this.getClass().getName());
//
//    }

//    public  (Class<?> obj) {
//        BeanUtils.copyProperties(obj, this);
//    }



}
