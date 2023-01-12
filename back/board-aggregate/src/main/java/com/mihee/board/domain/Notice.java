package com.mihee.board.domain;

import com.mihee.board.domain.vo.OpenStatus;
import com.mihee.board.util.EntityUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Notice extends BaseEntity{
    private String title;
    private String contents;
    private String writer;
    private OpenStatus openStatus;

    public void modifyValues(Notice notice) {
        Map<String, Object> valueList = EntityUtil.MapFromObj(notice);
        for(Map.Entry<String, Object> entry: valueList.entrySet()) {
            if (entry.getValue() != null) {
                switch (entry.getKey()) {
                    case "title":
                        this.title = entry.getValue().toString();
                        break;
                    case "contents":
                        this.contents = entry.getValue().toString();
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
