package com.mihee.board.store.mongo.repository;

import com.mihee.board.store.mongo.repository.doc.FaqDoc;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FaqRepository extends MongoRepository<FaqDoc, String> {
}
