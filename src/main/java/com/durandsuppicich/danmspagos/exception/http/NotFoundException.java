package com.durandsuppicich.danmspagos.exception.http;

public class NotFoundException extends RuntimeException {
    
    private static final String DEFAULT_MESSAGE = "Not Found Exception (404). ";

    public NotFoundException(String message) {
        super(DEFAULT_MESSAGE + message);
    }
}