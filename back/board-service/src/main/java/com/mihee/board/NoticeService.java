package com.mihee.board;

import com.mihee.board.domain.Notice;

import java.util.List;

public interface NoticeService {
    void createBoard(Notice notice);
    Notice getBoardById(String id);
    void update(Notice notice);
    List<Notice> getAllBoard();
    void removeBoardById(String id);
}
