package com.mihee.board.store.mongo.impl;

import com.mihee.board.domain.Faq;
import com.mihee.board.store.mongo.FaqStore;
import com.mihee.board.store.mongo.repository.FaqRepository;
import com.mihee.board.store.mongo.repository.doc.FaqDoc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FaqStoreImpl implements FaqStore {
    private final FaqRepository faqRepository;
    @Override
    public void create(Faq faq) {
        FaqDoc faqDoc = new FaqDoc(faq);
        this.faqRepository.save(faqDoc);
    }

    @Override
    public Faq findById(String id) {
        return this.faqRepository.findById(id).get().toDomain();
    }

    @Override
    public void modify(Faq faq) {
        FaqDoc faqDoc = new FaqDoc(faq);
        this.faqRepository.save(faqDoc);
    }

    @Override
    public Boolean isExist(String id) {
        return this.faqRepository.findById(id).isPresent();
    }

    @Override
    public List<Faq> findAll() {
        return FaqDoc.toDomains(this.faqRepository.findAll());
    }

    @Override
    public void deleteBoardById(String id) {
        this.faqRepository.deleteById(id);
    }
}
