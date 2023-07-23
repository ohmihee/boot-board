package com.mihee.board.domain.dto.board;

import com.mihee.board.domain.BaseEntity;
import com.mihee.board.domain.Board;
import com.mihee.board.domain.dto.WriterCdo;
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
@NoArgsConstructor
@AllArgsConstructor
public class BoardRdo extends BaseEntity {

    private String category;
    private String title;
    private List<BoardContent> contents;
    private WriterCdo writer;
    private OpenStatus openStatus;

    public BoardRdo(Board board) {
        BeanUtils.copyProperties(board, this);
        //this.writerName = board.getWriter().getUserName();
    }

}
