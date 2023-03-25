package com.mihee.board;

import com.mihee.board.domain.dto.UserJoinCdo;
import com.mihee.board.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody UserJoinCdo userJoinCdo) {
        userService.join(userJoinCdo.getUserName(), userJoinCdo.getPassword());
        return ResponseEntity.ok().body("Success");

    }
    //public ResponseEntity
}
