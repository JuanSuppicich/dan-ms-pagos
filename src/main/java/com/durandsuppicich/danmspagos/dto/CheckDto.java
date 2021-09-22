package com.durandsuppicich.danmspagos.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.Instant;

public class CheckDto extends PaymentMethodDto {

    @NotNull
    @Positive
    private int number;

    @NotNull
    @Future
    private Instant paymentDate;

    @NotBlank
    @Length(max = 32)
    private String bank;

    public CheckDto() {
    }

    public CheckDto(String comment, int number, Instant paymentDate, String bank) {
        super(comment);
        this.number = number;
        this.paymentDate = paymentDate;
        this.bank = bank;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Instant getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Instant paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }
}
