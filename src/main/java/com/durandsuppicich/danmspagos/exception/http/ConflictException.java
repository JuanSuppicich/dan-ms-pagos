package com.durandsuppicich.danmspagos.exception.http;

public class ConflictException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Conflict Exception (409). ";

    public ConflictException(String message) {
        super(DEFAULT_MESSAGE + message);
    }
}