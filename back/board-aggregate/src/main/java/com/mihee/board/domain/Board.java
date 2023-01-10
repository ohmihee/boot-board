package com.mihee.board.domain;

import com.mihee.board.domain.vo.BoardContent;
import com.mihee.board.domain.vo.OpenStatus;
import com.mihee.board.util.EntityUtil;
import lombok.*;
import java.util.List;
import java.util.Map;

//@Data
// @Getter @Setter @ToString @EqualsAndHashCod @RequiredArgsConstructor
// @Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Board extends BaseEntity {

    private String category;
    private String title;
    private String contents;
    private String writer;
    private OpenStatus openStatus;

    public void modifyValues(Board board) {
        Map<String, String> valueList = EntityUtil.MapFromObj(board);
        for (Map.Entry<String, String> entry: valueList.entrySet()) {
            if (entry.getValue() != null) {
                switch ( entry.getKey() ) {
                    case "title":
                        this.title = entry.getValue();
                        break;
                    case "category":
                        this.category = entry.getValue();
                        break;
                    case "contents":
                        this.contents = entry.getValue();
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

    public static void main(String[] args) {

    }
}

