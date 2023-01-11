package com.mihee.board;

import com.mihee.board.domain.Faq;

import java.util.List;

public interface FaqService {
    void createBoard(Faq faq);
    Faq getBoardById(String id);
    void update (Faq faq);
    List<Faq> getAllBoard();
    void removeBoardById(String id);
}
