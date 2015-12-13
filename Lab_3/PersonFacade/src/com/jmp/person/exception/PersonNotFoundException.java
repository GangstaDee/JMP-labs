package com.jmp.person.exception;

/**
 * Created on 13.12.2015.
 */
public class PersonNotFoundException extends Exception {

    private String message;

    public PersonNotFoundException(String message) {
        this.message = message;
    }

}
