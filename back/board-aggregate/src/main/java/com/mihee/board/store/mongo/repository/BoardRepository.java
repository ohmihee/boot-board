package com.mihee.board.store.mongo.repository;

import com.mihee.board.domain.Board;
import com.mihee.board.store.mongo.repository.doc.BoardDoc;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface BoardRepository extends MongoRepository<BoardDoc, String> {

    List<BoardDoc> findAllByCategory(String category);
}
