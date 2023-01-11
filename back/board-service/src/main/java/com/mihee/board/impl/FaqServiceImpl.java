package com.mihee.board.impl;

import com.mihee.board.FaqService;
import com.mihee.board.domain.Faq;
import com.mihee.board.store.mongo.FaqStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FaqServiceImpl implements FaqService {
    private final FaqStore faqStore;
    @Override
    public void createBoard(Faq faq) {
        this.faqStore.create(faq);
    }

    @Override
    public Faq getBoardById(String id) {
        return this.faqStore.findById(id);
    }

    @Override
    public void update(Faq faq) {
        Faq newFaq = this.faqStore.findById(faq.getId());
        newFaq.modifyValues(faq);
        this.faqStore.modify(newFaq);
    }

    @Override
    public List<Faq> getAllBoard() {
        return this.faqStore.findAll();
    }

    @Override
    public void removeBoardById(String id) {
        this.faqStore.deleteBoardById(id);
    }
}
