package com.durandsuppicich.danmspagos.exception.http;

public class BadRequestException extends RuntimeException {
    
    private static final String DEFAULT_MESSAGE = "Bad Request Exception (400). ";

    public BadRequestException(String message) {
        super(DEFAULT_MESSAGE + message);
    }
}