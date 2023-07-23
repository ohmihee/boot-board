package com.mihee.board.domain.dto.board;

import com.mihee.board.domain.Board;
import com.mihee.board.domain.User;
import com.mihee.board.domain.vo.BoardContent;
import com.mihee.board.domain.vo.OpenStatus;
import com.mihee.board.store.mongo.repository.doc.BoardDoc;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardCdo {

    private String category;
    private String title;
    private List<BoardContent> contents;
    private OpenStatus openStatus;

    public BoardDoc toDomain() {
        BoardDoc boardDoc = new BoardDoc();
        BeanUtils.copyProperties(this, boardDoc);
        return boardDoc;
    }
}
