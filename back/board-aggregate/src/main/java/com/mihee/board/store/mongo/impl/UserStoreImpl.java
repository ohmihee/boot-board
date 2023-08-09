package com.mihee.board.store.mongo.impl;

import com.mihee.board.domain.User;
import com.mihee.board.store.mongo.UserStore;
import com.mihee.board.store.mongo.repository.UserRepository;
import com.mihee.board.store.mongo.repository.doc.UserDoc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserStoreImpl implements UserStore {

    private final UserRepository userRepository;

    @Override
    public User create(UserDoc userDoc) {
        User user = new User(userDoc);
        return this.userRepository.save(user);
    }
}
