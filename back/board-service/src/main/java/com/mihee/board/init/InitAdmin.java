package com.mihee.board.init;


import com.mihee.board.store.mongo.UserStore;
import com.mihee.board.store.mongo.repository.doc.UserDoc;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InitAdmin implements InitializingBean {

    private final UserStore userStore;

    @Override
    public void afterPropertiesSet() throws Exception {
        init();
    }

    public void init() {
        System.out.println("create admin----");
        UserDoc userDoc = new UserDoc(
                "admin",
                "admin",
                "1234",
                "admin@email.com",
                "Admin"
        );

        userStore.create(userDoc);
    }
}
