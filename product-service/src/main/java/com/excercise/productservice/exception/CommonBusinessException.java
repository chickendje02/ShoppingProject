package com.excercise.productservice.exception;

public class CommonBusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CommonBusinessException(String msg) {
        super(msg);
    }
}
