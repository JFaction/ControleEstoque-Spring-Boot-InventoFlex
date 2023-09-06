package com.InventoFlex.exception;

public class UniqueConstraintViolationException extends RuntimeException{
    private static final long serialVersionUID = 1;

    public UniqueConstraintViolationException(String message){
        super(message);
    }
}
