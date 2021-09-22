package com.durandsuppicich.danmspagos.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class TransferDto extends PaymentMethodDto {

    @NotBlank
    @Length(min = 22, max = 22)
    private String cbuOrigin;

    @NotBlank
    @Length(min = 22, max = 22)
    private String cbuDestination;

    @NotNull
    @Positive
    private Long code;

    public TransferDto() {
    }

    public TransferDto(String comment, String cbuOrigin, String cbuDestination, Long code) {
        super(comment);
        this.cbuOrigin = cbuOrigin;
        this.cbuDestination = cbuDestination;
        this.code = code;
    }

    public String getCbuOrigin() {
        return cbuOrigin;
    }

    public void setCbuOrigin(String cbuOrigin) {
        this.cbuOrigin = cbuOrigin;
    }

    public String getCbuDestination() {
        return cbuDestination;
    }

    public void setCbuDestination(String cbuDestination) {
        this.cbuDestination = cbuDestination;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }
}
