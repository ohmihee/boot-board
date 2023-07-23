package com.mihee.board;

public interface UserService {

    String join(String nick, String password);

    String login(String nick, String password);
}
