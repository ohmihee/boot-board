package com.mihee.board.impl;

import com.mihee.board.FaqService;
import com.mihee.board.domain.Faq;
import com.mihee.board.store.mongo.FaqStore;
import com.mihee.board.store.mongo.repository.doc.FaqDoc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FaqServiceImpl implements FaqService {
    private final FaqStore faqStore;
    @Override
    public String createBoard(FaqDoc faqDoc) {
        return this.faqStore.create(faqDoc);
    }

    @Override
    public Faq getBoardById(String id) {
        return this.faqStore.findById(id);
    }

    @Override
    public String update(FaqDoc faqDoc) {
        Faq newFaq = this.faqStore.findById(faqDoc.getId());
        newFaq.modifyValues(faqDoc);
        return this.faqStore.modify(newFaq);
    }

    @Override
    public List<FaqDoc> getAllBoard() {
        return this.faqStore.findAll();
    }

    @Override
    public void removeBoardById(String id) {
        this.faqStore.deleteBoardById(id);
    }
}
