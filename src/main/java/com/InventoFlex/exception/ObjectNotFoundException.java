package com.InventoFlex.exception;

public class ObjectNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1;

    public ObjectNotFoundException(String message){
        super(message);
    }
}
