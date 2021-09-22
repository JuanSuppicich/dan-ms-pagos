package com.durandsuppicich.danmspagos.exception.payment;

import com.durandsuppicich.danmspagos.exception.http.NotFoundException;

public class PaymentNotFoundException extends NotFoundException {

    private static final String DEFAULT_MESSAGE = "Payment could not be found. ";

    public PaymentNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public PaymentNotFoundException(String message) {
        super(DEFAULT_MESSAGE + message);
    }
}
