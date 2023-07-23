package com.mihee.board.domain;

import com.mihee.board.store.mongo.repository.doc.UserDoc;
import lombok.*;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    private String userName;
    private String nick;
    private String password;
    private String email;
    private String role;

//    @DBRef(lazy = true)
//    private List<Board> boards = new ArrayList<>();
//    @DBRef(lazy = true)
//    private List<Faq> faqs = new ArrayList<>();
//    @DBRef(lazy = true)
//    private List<Notice> notices = new ArrayList<>();
//    @DBRef(lazy = true)
//    private List<Qna> qnas = new ArrayList<>();


    public User(UserDoc userDoc) {
        BeanUtils.copyProperties(userDoc, this);
    }


    public UserDoc toDomain() {
        UserDoc userDoc = new UserDoc();
        BeanUtils.copyProperties(this, userDoc);
        return userDoc;
    }

}
