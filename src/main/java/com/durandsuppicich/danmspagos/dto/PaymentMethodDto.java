package com.durandsuppicich.danmspagos.dto;

import com.durandsuppicich.danmspagos.domain.Cash;
import com.durandsuppicich.danmspagos.domain.Check;
import com.durandsuppicich.danmspagos.domain.Transfer;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, property="type")
@JsonSubTypes({
        @JsonSubTypes.Type(value= CashDto.class, name="cash"),
        @JsonSubTypes.Type(value= CheckDto.class, name="check"),
        @JsonSubTypes.Type(value= TransferDto.class, name="transfer")
})
public class PaymentMethodDto {

    @NotBlank
    @Length(max = 128)
    private String comment;

    public PaymentMethodDto() {
    }

    public PaymentMethodDto(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
