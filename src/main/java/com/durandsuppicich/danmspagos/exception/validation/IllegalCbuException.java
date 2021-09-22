package com.durandsuppicich.danmspagos.exception.validation;

import com.durandsuppicich.danmspagos.exception.http.BadRequestException;

public class IllegalCbuException extends BadRequestException {

    private static final String DEFAULT_MESSAGE = "Illegal call. Origin cbu and destination cbu can not be the same. ";

    public IllegalCbuException() {
        super(DEFAULT_MESSAGE);
    }

    public IllegalCbuException(String cbuOrigin, String cbuDestination) {
        super(DEFAULT_MESSAGE + "The given origin cbu is " + "{" + cbuOrigin + "}"
                + " and the given destination cbu is " + "{" + cbuDestination +"}");
    }
}
