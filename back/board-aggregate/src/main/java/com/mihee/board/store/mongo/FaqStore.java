package com.mihee.board.store.mongo;

import com.mihee.board.domain.Faq;
import com.mihee.board.store.mongo.repository.doc.FaqDoc;

import java.util.List;

public interface FaqStore {
    String create (FaqDoc faq);
    Faq findById (String id);
    String modify (Faq faq);
    Boolean isExist (String id);
    List<FaqDoc> findAll ();
    void deleteBoardById (String id);
}
