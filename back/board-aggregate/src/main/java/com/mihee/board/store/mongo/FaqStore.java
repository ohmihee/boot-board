package com.mihee.board.store.mongo;

import com.mihee.board.domain.Faq;

import java.util.List;

public interface FaqStore {
    void create (Faq faq);
    Faq findById (String id);
    void modify (Faq faq);
    Boolean isExist (String id);
    List<Faq> findAll ();
    void deleteBoardById (String id);
}
