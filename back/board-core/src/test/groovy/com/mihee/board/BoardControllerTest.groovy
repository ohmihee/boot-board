package com.mihee.board

import com.mihee.board.domain.Board
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class BoardControllerTest extends Specification{

    @Autowired
    private BoardService boardService;

    @Test
    def "createBoard" () {
        given:
        def board  = Board.sample();

        when:
        def savedBoard = boardService.createBoard(board);
        def id = savedBoard.getId();

        then:
        def findBoard = boardService.getBoardById(id);
        board.getTitle().equals(findBoard.getTitle());
    }

}
