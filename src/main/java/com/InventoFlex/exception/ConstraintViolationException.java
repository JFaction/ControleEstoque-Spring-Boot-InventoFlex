package com.InventoFlex.exception;

public class ConstraintViolationException extends RuntimeException {

    private static final long serialVersionUID = 1;

    public ConstraintViolationException(String message){
        super(message);
    }
}
