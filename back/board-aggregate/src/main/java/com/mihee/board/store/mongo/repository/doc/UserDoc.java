package com.mihee.board.store.mongo.repository.doc;

import com.mihee.board.domain.BaseEntity;
import com.mihee.board.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("User")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDoc extends BaseEntity {

    private String userName;
    private String nick;
    private String password;
    private String email;
    private String role;

    public User toDomain() {
        User user = new User();
        BeanUtils.copyProperties(this, user);
        return user;
    }

    public void toDoc(User user) {
        BeanUtils.copyProperties(user, this);
    }
}
