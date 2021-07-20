package com.durandsuppicich.danmspagos.dto;

import org.hibernate.validator.constraints.Mod11Check;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class CashDto extends PaymentMethodDto {

    @NotNull
    @Positive
    @Mod11Check
    private int billNumber;

    public CashDto() {
    }

    public CashDto(String comment, int billNumber) {
        super(comment);
        this.billNumber = billNumber;
    }

    public int getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(int billNumber) {
        this.billNumber = billNumber;
    }
}
