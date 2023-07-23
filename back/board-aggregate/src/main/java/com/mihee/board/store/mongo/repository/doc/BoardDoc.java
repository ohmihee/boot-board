package com.mihee.board.store.mongo.repository.doc;

import com.mihee.board.domain.BaseEntity;
import com.mihee.board.domain.Board;
import com.mihee.board.domain.dto.board.BoardCdo;
import com.mihee.board.domain.dto.WriterCdo;
import com.mihee.board.domain.vo.BoardContent;
import com.mihee.board.domain.vo.OpenStatus;
import lombok.*;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.stream.Collectors;

@Document("Board")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardDoc extends BaseEntity {

    private String category;
    private String title;
    private List<BoardContent> contents;
    private WriterCdo writer;
    private OpenStatus openStatus;

    public BoardDoc(Board board) {
        //Authentication auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        BeanUtils.copyProperties(board, this);
        this.writer = new WriterCdo("id", "nick");
    }

    public static List<Board> toDomains(List<BoardDoc> boards) {
        return boards.stream().map(BoardDoc::toDomain).collect(Collectors.toList());
    }

    // 데이터베이스를 자바 객체로
    public Board toDomain() {
        Board board = new Board();
        BeanUtils.copyProperties(this, board);
        return board;
    }
}

//
//    public static List<Board> toDomains(List<BoardDoc> boards) {
//        return boards.stream().map(BoardDoc:: toDomain).collect(Collectors.toList());
//    }

// 자바 데이터를 데이터베이스로
//    public BoardDoc(BoardDoc boardDoc) {
//        BeanUtils.copyProperties(boardDoc, this);
//    }