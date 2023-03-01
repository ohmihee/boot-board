package com.mihee.board.domain;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.mihee.board.domain.vo.BoardContent;
import com.mihee.board.domain.vo.OpenStatus;
import com.mihee.board.store.mongo.repository.doc.BoardDoc;
import com.mihee.board.util.EntityUtil;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

//    public VideoContent(VideoContentCdo videoContentCdo) {
//        super(videoContentCdo.genId(), videoContentCdo.getRequesterKey());
//        BeanUtils.copyProperties(videoContentCdo, this);
//    }

    public Board(BoardDoc boardDoc) {
        BeanUtils.copyProperties(boardDoc, this);
    }

    public BoardDoc toDomain() {
        BoardDoc boardDoc = new BoardDoc();
        BeanUtils.copyProperties(this, boardDoc);
        return boardDoc;
    }

    public static List<BoardDoc> toDomains(List<Board> boards) {
        return boards.stream().map(Board::toDomain).collect(Collectors.toList());

    }
    public void modifyValues(BoardDoc boardDoc) {
        Map<String, Object> valueList = EntityUtil.MapFromObj(boardDoc);
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

    public static Board sample () {
        Board board = new Board();
        board.setTitle("안녕하세요2");
        board.setCategory("일반");
        ArrayList<BoardContent> boardContents = new ArrayList<>();
        boardContents.add(new BoardContent(1,"title","내용입니다."));
        board.setContents(boardContents);
        board.setOpenStatus(OpenStatus.All);
        return board;
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
        //aa.modifyValues(test);
        System.out.println(aa.getTitle()+"============");
        System.out.println(aa.getContents());
    }
}