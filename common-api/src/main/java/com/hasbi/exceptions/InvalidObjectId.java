package com.hasbi.exceptions;

public class InvalidObjectId extends RuntimeException{
    public InvalidObjectId(String message) {
        super(message);
    }
}
