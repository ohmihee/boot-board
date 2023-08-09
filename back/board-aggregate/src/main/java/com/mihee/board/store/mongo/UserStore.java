package com.mihee.board.store.mongo;

import com.mihee.board.domain.User;
import com.mihee.board.store.mongo.repository.doc.UserDoc;

public interface UserStore {

    User create(UserDoc user);
}
