package com.mihee.board.domain;

import com.mihee.board.domain.vo.OpenStatus;

public class Notice extends BaseEntity{
    private String title;
    private String contents;
    private String user;
    private OpenStatus openStatus;
}
