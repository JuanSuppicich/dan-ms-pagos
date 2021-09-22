package com.durandsuppicich.danmspagos.exception.http;

public class UnauthorizedException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Unauthorized Exception (401). ";

    public UnauthorizedException(String message) {
        super(DEFAULT_MESSAGE + message);
    }
}