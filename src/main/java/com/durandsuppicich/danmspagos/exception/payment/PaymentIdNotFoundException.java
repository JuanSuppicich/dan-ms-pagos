package com.durandsuppicich.danmspagos.exception.payment;

public class PaymentIdNotFoundException extends PaymentNotFoundException {

    private static final String DEFAULT_MESSAGE = "The given id does not belong to any payment bill. ";

    public PaymentIdNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public PaymentIdNotFoundException(Integer id) {
        super(DEFAULT_MESSAGE + "{" + id + "}");
    }
}
