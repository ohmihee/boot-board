package com.mihee.board.domain;

import com.mihee.board.util.EntityUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Faq extends BaseEntity{
    private String title;
    private String question;
    private String answer;
    private String writer;

    public void modifyValues(Faq faq) {
        Map<String, String> valueList = EntityUtil.MapFromObj(faq);
        for(Map.Entry<String, String> entry: valueList.entrySet()) {
            if (entry.getValue() != null) {
                switch (entry.getKey()) {
                    case "title":
                        this.title = entry.getValue();
                        break;
                    case "question":
                        this.question = entry.getValue();
                        break;
                    case "answer":
                        this.answer = entry.getValue();
                        break;
                }
            }
        }
    }
}
