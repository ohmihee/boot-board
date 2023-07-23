package com.mihee.board.impl;

import com.mihee.board.AddException;
import com.mihee.board.ErrorCode;
import com.mihee.board.UserService;
import com.mihee.board.domain.User;
import com.mihee.board.store.mongo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public String join(String nick, String password) {
        // 중복 체크

        userRepository.findByNick(nick).ifPresent(user -> {
            throw new AddException(ErrorCode.USERNAME_DUPLICATED,
                    "already exist username:" + nick);
        });
        User user = User.builder()
                .nick(nick)
                .password(encoder.encode(password))
                .build();
        userRepository.save(user);
        return "SUCCESS";
    }

    public String login(String nick, String password) {
        // userName 존재하지 않는 경우
        User findUser = userRepository.findByNick(nick).orElseThrow(
                () -> new AddException(ErrorCode.USERNAME_NOT_FOUNDED, nick + "not exist"));

        // userName password 일치하지 않는 경우
//        if (!encoder.matches(findUser.getPassword(), password)) {
//            throw new AddException(ErrorCode.INVALID_PASSWORD, "invalid password");
//        }
        return "token";
    }
}
