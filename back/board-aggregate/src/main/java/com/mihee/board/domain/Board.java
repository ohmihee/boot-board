package com.mihee.board.domain;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.mihee.board.domain.vo.BoardContent;
import com.mihee.board.domain.vo.OpenStatus;
import com.mihee.board.util.EntityUtil;
import lombok.*;

import java.util.ArrayList;
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
    private List<BoardContent> contents;
    private String writer;
    private OpenStatus openStatus;

    public void modifyValues(Board board) {
        Map<String, Object> valueList = EntityUtil.MapFromObj(board);
        for (Map.Entry<String, Object> entry: valueList.entrySet()) {
            if (entry.getValue() != null) {
                switch ( entry.getKey() ) {
                    case "title":
                        this.title = entry.getValue().toString();
                        break;
                    case "category":
                        this.category = entry.getValue().toString();
                        break;
                    case "contents":
                        System.out.println(entry.getValue()+"contents====");
                        this.contents = (List<BoardContent>) entry.getValue();
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
        Board test = new Board();
        BoardContent content = new BoardContent();
        BoardContent content2 = new BoardContent();
        ArrayList<BoardContent> contents = new ArrayList<BoardContent>();
        contents.add(content);
        contents.add(content2);
        Board aa = new Board();
        content2.setContent("wowowowowo");
        test.setContents(contents);
        test.setTitle("test");
        aa.modifyValues(test);
        System.out.println(aa.getTitle()+"============");
        System.out.println(aa.getContents());
    }
}