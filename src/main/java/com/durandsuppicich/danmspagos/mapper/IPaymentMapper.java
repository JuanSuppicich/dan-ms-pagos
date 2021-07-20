package com.durandsuppicich.danmspagos.mapper;

import com.durandsuppicich.danmspagos.domain.Payment;
import com.durandsuppicich.danmspagos.dto.PaymentDto;

import java.util.List;

public interface IPaymentMapper {

    Payment map(PaymentDto paymentDto);

    PaymentDto map(Payment payment);

    List<PaymentDto> map(List<Payment> payments);

}
