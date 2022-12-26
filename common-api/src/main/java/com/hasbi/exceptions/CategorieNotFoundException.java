package com.hasbi.exceptions;

public class CategorieNotFoundException extends RuntimeException{

    public CategorieNotFoundException(String message) {
        super(message);
    }
}
