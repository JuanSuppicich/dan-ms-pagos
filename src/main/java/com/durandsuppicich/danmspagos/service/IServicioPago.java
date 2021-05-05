package com.durandsuppicich.danmspagos.service;

import java.util.List;
import java.util.Optional;

import com.durandsuppicich.danmspagos.domain.Pago;

public interface IServicioPago {

    Pago crear(Pago pago);
    List<Pago> todos();
    Optional<Pago> pagoPorId(Integer id);
}