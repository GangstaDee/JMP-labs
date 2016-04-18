package com.jmp.api.exception;

public class DataNotFoundException extends Exception {

    private String message;
    private Object objectID;

    public DataNotFoundException(String message, Object objectID) {
        this.message = message;
        this.objectID = objectID;
    }

    @Override
    public String toString() {
        return "DataNotFoundException: " + message +
                ", object ID -" + objectID;
    }
}
