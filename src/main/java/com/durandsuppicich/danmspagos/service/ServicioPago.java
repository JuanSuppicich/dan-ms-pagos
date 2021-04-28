package com.durandsuppicich.danmspagos.service;

import java.util.List;
import java.util.Optional;

import com.durandsuppicich.danmspagos.dao.PagoJpaRepository;
import com.durandsuppicich.danmspagos.domain.Pago;

import org.springframework.stereotype.Service;

@Service
public class ServicioPago implements IServicioPago {

    private final PagoJpaRepository pagoRepository;

    public ServicioPago(PagoJpaRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    @Override
    public Pago crear(Pago pago) {
        return pagoRepository.save(pago);
    }

    @Override
    public List<Pago> todos() {
        return pagoRepository.findAll();
    }

    @Override
    public Optional<Pago> pagoPorId(Integer id) {
        return pagoRepository.findById(id);
    }

    @Override
    public void actualizar(Integer id, Pago pago) {
        if (pagoRepository.existsById(id)) {
            pagoRepository.save(pago);
        }
        else {
            // Lanzar excepción
        }
    }

    @Override
    public void eliminar(Integer id) {
        if (pagoRepository.existsById(id)) {
            pagoRepository.deleteById(id);
        }
        else {
            // Lanzar excepción
        }
    }
}