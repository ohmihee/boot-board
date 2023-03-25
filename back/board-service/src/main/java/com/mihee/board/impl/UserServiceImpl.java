package com.mihee.board.impl;

import com.mihee.board.UserService;
import com.mihee.board.domain.User;
import com.mihee.board.store.mongo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public String join (String userName, String password) {
        // 중복 체크
        userRepository.findByUserName(userName).ifPresent(user -> {throw new RuntimeException("already exist username:" + userName); });
        User user = User.builder()
                .userName(userName)
                .password(password)
                        .build();
        userRepository.save(user);
        return "SUCCESS";
    }
}
