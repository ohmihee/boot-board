package com.mihee.board.store.mongo.repository;

import com.mihee.board.domain.Board;
import com.mihee.board.store.mongo.repository.doc.BoardDoc;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface BoardRepository extends MongoRepository<Board, String> {
}
