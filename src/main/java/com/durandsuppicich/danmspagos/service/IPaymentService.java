package com.durandsuppicich.danmspagos.service;

import java.util.List;

import com.durandsuppicich.danmspagos.domain.Payment;

public interface IPaymentService {

    Payment post(Payment payment);
    List<Payment> getAll();
    Payment getById(Integer id);
    List<Payment> getByCustomerCuit(String cuit);
}