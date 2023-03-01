package com.mihee.board;

import com.mihee.board.domain.Faq;
import com.mihee.board.store.mongo.repository.doc.FaqDoc;

import java.util.List;

public interface FaqService {
    String createBoard(FaqDoc faqDoc);
    Faq getBoardById(String id);
    String update (FaqDoc faqDoc);
    List<FaqDoc> getAllBoard();
    void removeBoardById(String id);
}
