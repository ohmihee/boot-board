package com.mihee.board.store.mongo.repository;

import com.mihee.board.store.mongo.repository.doc.QnaDoc;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QnaRepository extends MongoRepository<QnaDoc, String> {
}
