package com.mihee.board.domain;


import com.mihee.board.domain.dto.board.BoardUdo;
import com.mihee.board.domain.dto.WriterCdo;
import com.mihee.board.domain.vo.BoardContent;
import com.mihee.board.domain.vo.OpenStatus;
import com.mihee.board.store.mongo.repository.doc.BoardDoc;
import com.mihee.board.util.EntityUtil;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
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
    private WriterCdo writer;
    private OpenStatus openStatus;

    public Board(BoardDoc boardDoc) {
        BeanUtils.copyProperties(boardDoc, this);
    }

    public static List<BoardDoc> toDomains(List<Board> boards) {
        return boards.stream().map(Board::toDomain).collect(Collectors.toList());
    }

    public static Board sample() {
        Board board = new Board();
        board.setTitle("안녕하세요2");
        board.setCategory("일반");
        ArrayList<BoardContent> boardContents = new ArrayList<>();
        boardContents.add(new BoardContent(1, "title", "내용입니다."));
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
        System.out.println(aa.getTitle() + "============");
        System.out.println(aa.getContents());
    }

    public BoardDoc toDomain() {
        BoardDoc boardDoc = new BoardDoc();
        BeanUtils.copyProperties(this, boardDoc);
        return boardDoc;
    }

    public void modifyValues(BoardUdo boardUdo) {
        Map<String, Object> valueList = EntityUtil.MapFromObj(boardUdo);
        for (Map.Entry<String, Object> entry : valueList.entrySet()) {
            if (entry.getValue() != null) {
                switch (entry.getKey()) {
                    case "title":
                        this.title = entry.getValue().toString();
                        break;
                    case "category":
                        this.category = entry.getValue().toString();
                        break;
                    case "contents":
                        System.out.println(entry.getValue() + "contents====");
                        this.contents = (List<BoardContent>) entry.getValue();
                        break;
                    case "openStatus":
                        if (entry.getValue().equals("All")) {
                            this.openStatus = OpenStatus.All;
                        }
                        if (entry.getValue().equals("OnlyAdmin")) {
                            this.openStatus = OpenStatus.OnlyAdmin;
                        }
                        break;
                }
            }
        }
    }
}