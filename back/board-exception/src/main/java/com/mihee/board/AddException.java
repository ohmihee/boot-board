package com.mihee.board;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public class AddException extends RuntimeException {
    private ErrorCode errorCode;
    private String message;
}
