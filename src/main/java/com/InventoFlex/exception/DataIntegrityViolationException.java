package com.InventoFlex.exception;

public class DataIntegrityViolationException extends RuntimeException{
    private static final long serialVersionUID = 1;

    public DataIntegrityViolationException(String message){
        super(message);
    }
}
