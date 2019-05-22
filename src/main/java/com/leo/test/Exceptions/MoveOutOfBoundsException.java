package com.leo.test.Exceptions;

public class MoveOutOfBoundsException extends RuntimeException {
    public MoveOutOfBoundsException(String msg) {
        super(msg);
    }
    public MoveOutOfBoundsException() {
        super();
    }
}
