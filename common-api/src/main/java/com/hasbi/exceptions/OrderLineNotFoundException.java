package com.hasbi.exceptions;

public class OrderLineNotFoundException extends RuntimeException{

    public OrderLineNotFoundException(String message) {
        super(message);
    }
}
