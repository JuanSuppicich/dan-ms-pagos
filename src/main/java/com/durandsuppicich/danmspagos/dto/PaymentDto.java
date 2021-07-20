package com.durandsuppicich.danmspagos.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.Instant;

public class PaymentDto {

    @NotNull
    @Positive
    private Integer customerId;

    @NotNull
    @PastOrPresent
    private Instant paymentDate;

    @NotNull
    @Valid
    PaymentMethodDto method;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Instant getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Instant paymentDate) {
        this.paymentDate = paymentDate;
    }

    public PaymentMethodDto getMethod() {
        return method;
    }

    public void setMethod(PaymentMethodDto method) {
        this.method = method;
    }
}
