package com.durandsuppicich.danmspagos.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.Instant;

public class PaymentDto {

    @Null
    private Integer id;

    @NotNull
    @Positive
    private Integer customerId;

    @NotNull
    @PastOrPresent
    private Instant date;

    @NotNull
    @Valid
    PaymentMethodDto method;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public PaymentMethodDto getMethod() {
        return method;
    }

    public void setMethod(PaymentMethodDto method) {
        this.method = method;
    }
}
