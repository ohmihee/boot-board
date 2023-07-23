package com.mihee.board.store.mongo.repository;

import com.mihee.board.domain.Notice;
import com.mihee.board.store.mongo.repository.doc.NoticeDoc;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoticeRepository extends MongoRepository<NoticeDoc, String> {
}
