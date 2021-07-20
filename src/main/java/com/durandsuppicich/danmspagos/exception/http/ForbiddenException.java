package com.durandsuppicich.danmspagos.exception.http;

public class ForbiddenException extends RuntimeException {
    
    private static final String DEFAULT_MESSAGE = "Forbidden Exception (403). ";

    public ForbiddenException(String message) {
        super(DEFAULT_MESSAGE + message);
    }
}